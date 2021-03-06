package com.antifraud.controller;

import java.io.UnsupportedEncodingException;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.antifraud.dao.CompactDao;
import com.antifraud.dao.HousePropertyMortgageDao;
import com.antifraud.dao.VehicleMortgageDao;
import com.antifraud.entity.Compact;
import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.User;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.service.CompactService;
import com.antifraud.service.FiduciaryLoanService;
import com.antifraud.service.SpotRecordService;
import com.antifraud.utils.JsonUtil;
import com.antifraud.utils.MoneyUntil;
import com.antifraud.utils.UpdateFile;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;

/**
 * 
 *
 * @ClassName: CompactController
 * 
 * @description 签合同a
 *
 * @author lishaozhang
 * 
 */
@Controller
@RequestMapping("Compact")
public class CompactController {

	private static final Logger logger = Logger.getLogger(CompactController.class); 
	@Autowired
	private CompactService compactService;

	@Autowired
	private HousePropertyMortgageDao housePropertyMortgageDao;
	@Autowired
	private FiduciaryLoanService fiduciaryLoanService;

	@Autowired
	private VehicleMortgageDao vehicleMortgageDao; 
	@Autowired
	private CompactDao compactDao;
	@Autowired
	private SpotRecordService spotRecordService;

	/**
	 * 
	 *
	 * @Title: creatCompact
	 * 
	 * @description 跟据报单编号获取借款金额，期限，还款方式等信息生成合同
	 *
	 * @param  @param
	 *            entry_number 报单编号
	 * @param @return
	 * 
	 * @return ModelAndView
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2018年10月24日
	 */
	@RequestMapping("creatCompact")
	public ModelAndView creatCompact(@Param(value = "entry_number") String entry_number) {

		/** 报单编号头部标识符（FW XY CL） */
		String entry_number_head = entry_number.substring(0, 2);
		/** 借款金额 */
		BigDecimal apply_for_limit = null;
		/** 借款期限 */
		String approval_deadline = null;
		/** 合同编号 */
		String contract_id = null;
		/** 户籍地址 */
		String permanent_residence_address = null;
		
		ModelAndView modelAndView = new ModelAndView();
		
		//判断是那种贷款模式
		try {
			
			if ("XY".equals(entry_number_head)) {
	            
				FiduciaryLoan fiduciaryLoan = compactService.findByEntry_number(entry_number);
				// 获取借款金额
				apply_for_limit = fiduciaryLoan.getApply_for_limit();
				// 获取还款期限
				approval_deadline = fiduciaryLoan.getApproval_deadline();
				// 获取户籍地址
				permanent_residence_address = fiduciaryLoan.getPermanent_residence_address();
				
				modelAndView.addObject("obj", fiduciaryLoan);
				
			} else if ("FW".equals(entry_number_head)) {
			
				HousePropertyMortgage housePropertyMortgage = housePropertyMortgageDao.findByEntryNumber(entry_number);
				// 获取借款金额
				apply_for_limit = housePropertyMortgage.getApply_for_limit();
				// 获取还款期限
				approval_deadline = housePropertyMortgage.getApproval_deadline();
				// 获取户籍地址
				permanent_residence_address = housePropertyMortgage.getPermanent_residence_address();
	
				modelAndView.addObject("obj", housePropertyMortgage);
			} else {
	
				VehicleMortgage vehicleMortgage = vehicleMortgageDao.findByEntryNumber(entry_number);
				// 获取借款金额
				apply_for_limit = vehicleMortgage.getApply_for_limit();
				// 获取还款期限			
				approval_deadline = vehicleMortgage.getApproval_deadline();		
				// 获取户籍地址
				permanent_residence_address = vehicleMortgage.getPermanent_residence_address();
				
				modelAndView.addObject("obj", vehicleMortgage);
			}
			// 获取最后一条插入数据库的合同信息
			Compact lastCompact = compactService.findLastCompact();
			
			try {
				lastCompact.getContract_id();
			} catch (Exception e) {
				 lastCompact = new Compact();
				lastCompact.setContract_id(null);
			}
			
			// 生成合同编号
			// 如果这是第一条数据设置合同编号为ht000000001
			if (null == lastCompact.getContract_id() || "".equals(lastCompact.getContract_id())) {
				contract_id = "ht000000001";
			} else {
				// 如果不是第一个合同查询最后一条插入的合同获得编号 +1
				String contractNumber = (String) lastCompact.getContract_id().substring(2);
				int number = Integer.parseInt(contractNumber);
				number += 1;
	            
				contract_id = "ht";
				for (int i = 0; i < (9 - String.valueOf(number).length()); i++) {
					contract_id += "0";
				}
	
				contract_id += number;
			}
	
			// 合同编号封装
			modelAndView.addObject("pact_no", contract_id);
			
			// 借款金额小写格式转换
			StringBuilder stringBuilder = new StringBuilder(apply_for_limit.toString());
			// 获取金额中" . "的位置 
			int index = apply_for_limit.toString().indexOf(".");
			StringBuilder newStr = stringBuilder.insert(index, "0000");
			// 截取金额中整数部分
			modelAndView.addObject("lower_camount", newStr);
			// 将借款金额转换为大写形式
			String bid_camount = MoneyUntil.toChinese(newStr.toString());
			modelAndView.addObject("bid_camount", bid_camount.replace('元', ' '));
			
			// 获取当前 年/月/日
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
			int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
			
			// 审批期限+当前月份
			Integer totalMonth = month + Integer.parseInt(approval_deadline);
			// 存放还款时间Map集合 
			Map<String, Object> last_repay_time = new HashMap<>();
			//判断 审批期限+当前月份 是否超过12个月
			if(totalMonth > 12){
				//月份超过了12 还款月份
				int addyear = totalMonth / 12;
				int lastMonth = totalMonth % 12;
				//还款年份
				int lastyear = year + addyear;
				
				last_repay_time.put("year", lastyear);
				last_repay_time.put("month", lastMonth);
				last_repay_time.put("day", day);
			} else {
				last_repay_time.put("year", year);
				last_repay_time.put("month", month);
				last_repay_time.put("day", day);
			}
		
			// 最后还款时间
			modelAndView.addObject("last_repay_time", last_repay_time);
			// 还款日期单位
			modelAndView.addObject("period_unit", "月");
			// 存放户籍地址Map集合 
			Map<String, Object> permanentResidenceAddressMap = new HashMap<>();
			String province = "",city = "",county="";
			if (StringUtils.isNotEmpty(permanent_residence_address)) {
				// 获取"省"位置的索引
				int provinceIndex = permanent_residence_address.indexOf("省");
				// 获取"市"位置的索引
				int cityIndex = permanent_residence_address.indexOf("市");
				
				if (provinceIndex >= 0) {
					// 获取省份名称
					province = permanent_residence_address.substring(0, provinceIndex);
				}
				
				if (cityIndex >= 0) {
					// 获取市名称
					city = permanent_residence_address.substring(provinceIndex + 1, cityIndex);
				}
				// 获取县及辖属地区
				county = permanent_residence_address.substring(cityIndex + 1);
			}
			
			permanentResidenceAddressMap.put("province", province);
			permanentResidenceAddressMap.put("city", city);
			permanentResidenceAddressMap.put("county", county);
			
			modelAndView.addObject("permanentResidenceAddress", permanentResidenceAddressMap);
			
			// 返回Compact.jsp页面展示 页面待确定
			modelAndView.setViewName("/WEB-INF/campactJsp/printingContract");
	
			// 预先将报单编号及合同编号存入合同表 为了避免出现合同编号一样的情况
			List<Compact> findCompactByEntry_number = compactService.findCompactByEntry_number(entry_number);
			if(findCompactByEntry_number.size() == 0){
				Compact compact = new Compact();
				
				//获取当前Userid
		        User user = (User) SecurityUtils.getSubject().getPrincipal();
				
				Long user_id = user.getId();
				compact.setUser_id(user_id);
				compact.setContract_id(contract_id);
				compact.setReport_id(entry_number);
				compactService.insertCompact(compact);
	
			}else {
				// 合同编号封装
				modelAndView.addObject("pact_no", findCompactByEntry_number.get(0).getContract_id());
			}
			
			return modelAndView;
		} catch (Exception e) {
			//ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("msg", "报单模块数据库信息不完整");
			modelAndView.setViewName("/WEB-INF/campactJsp/printingContract");
			e.printStackTrace();
			return modelAndView;
		}
	}

	/**
	 * 
	 *
	 * @Title: upLoadCompact
	 * 
	 * @description 上传照片并保存实体类到数据库
	 *
	 * @param @param
	 *            entry_number
	 * @param @param
	 *            reamker
	 * @param @param
	 *            request
	 * @param @return
	 * 
	 * @return Map<String,String>
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2018年10月25日
	 */
	@RequestMapping("upLoadCompact")
	@ResponseBody
	public Object upLoadCompact(@Param(value = "report_id") String report_id, @Param(value = "reamker")String reamker,
			HttpServletRequest request) {
		 
		
		synchronized (CompactController.class) {
			
		
		// 获取前台传过来的所有图片
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		List<MultipartFile> files = multipartRequest.getFiles("file");
		Map map = compactService.upLoadCompact(report_id, files, reamker);
		
		//将报单状态修改为7		
		spotRecordService.judgementResult(report_id, 7,null);

		return JSONObject.toJSON(map);
		}       
	}

	/**
	 * 
	 *
	 * @Title: findAllCompact
	 * 
	 * @description 查询所有合同方法
	 *
	 * @param @return
	 * 
	 * @return List<Compact>
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2018年10月25日
	 */
	@RequestMapping("findAllCompact")
	@ResponseBody
	public Object findAllCompact(int page,int limit) {

		List<Compact> compactList = compactService.findAllCompact(page,limit);
		Map map = new HashMap<String, List<Compact>>();
		
		map.put("code", 1);
		map.put("data", compactList);
        map.put("count", compactDao.findAllCompactCount().size());
        map.put("msg", "查询成功");
		return JSONObject.toJSON(map);
	}

	/**
	 * 
	 *
	 * @Title: findCompactByEntry_number
	 * 
	 * @description 根据报单编号查询合同
	 *
	 * @param @param
	 *            entry_number
	 * @param @return
	 * 
	 * @return Object
	 *
	 * 
	 * @author lishaozhang
	 * @throws UnsupportedEncodingException
	 * @createDate 2018年10月25日
	 */
	@RequestMapping("findCompactByEntry_number")
	@ResponseBody
	public Object findCompactByEntry_number(@Param("entry_number") String entry_number)
			throws UnsupportedEncodingException {
		Map map = new HashMap<>();

		String entry_number2 = null;
		// 当传入属性名称与 entry_number 不符时抛异常返回传入正确的属性名称
		try {

			entry_number2 = new String(entry_number.getBytes("iso-8859-1"), "utf-8");

		} catch (Exception e) {

			map.put("code", -1);
			map.put("msg", "请传入正确的属性名称");
			map.put("count", null);
			map.put("data", null);
			return JSONObject.toJSON(map);
		}

		
		List<Compact> compactList = compactService.findCompactByEntry_number(entry_number2);
		// 根据报单编号查询不到合同时返回该用户没有合同
		if (compactList.size() <= 0) {

			map.put("code", -1);
			map.put("msg", "用户暂时没有合同");
			map.put("count", null);
			map.put("data", null);
			return JSONObject.toJSON(map);
		}
		map.put("code", 1);
		map.put("msg", "查询成功");
		map.put("count", compactList.size());
		map.put("data", compactList);
		// 根据报单编号查询到合同时返回所有合同
		return JSONObject.toJSON(map);
	}

	/**
	 * 
	 *
	 * @Title: deleteCompactByid
	 * 
	 * @description 根据id删除合同
	 *
	 * @param @param
	 *            id
	 * @param @return
	 * 
	 * @return Map
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2018年10月25日
	 */
	@RequestMapping("deleteCompactByid")
	@ResponseBody
	public Object deleteCompactByid(@Param("id") Long id) {
		int result = compactService.deleteCompactByid(id);
		Map<String,Object> map = new HashMap<>();
		if (result == 1) {
			map.put("code", 1);
			map.put("msg", "删除成功");
			map.put("count", null);
			map.put("data", null);
			return JSONObject.toJSON(map);
		}

		map.put("code", -1);
		map.put("msg", "删除失败");
		map.put("count", null);
		map.put("data", null);
		return JSONObject.toJSON(map);
	}

	/**
	 * 
	 *
	 * @Title: deleteCompactByReport_id
	 * 
	 * @description 跟据报单编号删除合同
	 *
	 * @param @param
	 *            report_id 传入参数报单编号
	 * @param @return
	 * 
	 * @return Map
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2018年10月25日
	 */
	@RequestMapping("deleteCompactByReport_id")
	@ResponseBody
	public Object deleteCompactByReport_id(@Param("id") String report_id) {
		int result = compactService.deleteCompactByReport_id(report_id);
		Map<String,Object> map = new HashMap<>();
		// 返回结果大于0代表有数据被删除
		if (result > 0) {
			map.put("code", 1);
			map.put("msg", "删除成功");
			map.put("count", null);
			map.put("data", null);
			return JSONObject.toJSON(map);
		} else {
			// 失败原因可能是数据库没有当前报单号的合同了
			map.put("code", -1);
			map.put("msg", "数据库没有当前编号的合同了");
			map.put("count", null);
			map.put("data", null);
		}

		return JSONObject.toJSON(map);
	}

	/**
	 * 
	 *
	 * @Title: updateCompactByContract_id
	 * 
	 * @description 修改合同方法 
	 *
	 * @param @param
	 *            compact
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2018年10月25日
	 */
	@RequestMapping("updateCompactByContract_id")
	public Object updateCompactByContract_id(Compact compact) {
		Map<String,Object> map = new HashMap<>();
		
		Date update_time = new Date();
		compact.setUpdate_time(update_time);
		int reulat = compactService.updateCompactByContract_id(compact);
		
		if(reulat<=0){
		map.put("code", -1);
		map.put("msg", "数据库没有当前编号的合同了");
		map.put("count", null);
		map.put("data", null);
		return JSONObject.toJSON(map);
		}
		
		map.put("code", 1);
		map.put("msg", "修改成功");
		map.put("count", null);
		map.put("data", null);
		
		return JSONObject.toJSON(map);
				

	}
	/**
	 * 
	*
	 * @Title: findallForCamapte
	
	 * @description 查询审核通过等待打印合同的信用贷款报单
	*
	 * @param @param page
	 * @param @param limit
	 * @param @return 
	   
	 * @return Object    
	
	 * @author lishaozhang
	 * @createDate 2018年11月8日
	 */
	@RequestMapping("findallForCamapte")
	@ResponseBody
	public Object findallForCamapte(int page,int limit){
		
		Map<String,Object> map =compactService.findallForCamapte(page,limit); 
		return JSONObject.toJSON(map);	
	}
	/**
	 * 
	*
	 * @Title: findallForCamapte
	
	 * @description 查询审核通过等待打印合同的房屋抵押贷款报单
	*
	 * @param @param page
	 * @param @param limit
	 * @param @return 
	   
	 * @return Object    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年11月8日
	 */
	@RequestMapping("findAllHousePropertyMortgageForCompact")
	@ResponseBody
	public Object findAllHousePropertyMortgageForCompact (int page,int limit){
	
		Map<String,Object> map =compactService.findAllHousePropertyMortgageForCompact(page,limit);
		
		return JSONObject.toJSON(map); 	
	}
	/**
	 * 
	*
	 * @Title: findAllVehicleMortgageForCamapte
	
	 * @description 分页查询所有可以签合同业务的车辆抵押业务报单
	*
	 * @param @param page
	 * @param @param limit
	 * @param @return 
	   
	 * @return Object    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年11月8日
	 */
	@RequestMapping("findAllVehicleMortgageForCamapte")
	@ResponseBody
	public Object findAllVehicleMortgageForCamapte (int page,int limit){
		Map<String,Object> map =compactService.findAllVehicleMortgageForCamapte(page,limit);
	
		return JSONObject.toJSON(map); 	
	}
	
	  
	/**
	 * 
	*
	 * @Title: findAllCompactImgIsNull
	
	 * @description 分页查询所有未上传图片的合同表
	*
	 * @param @param page
	 * @param @param limit
	 * @param @return 
	   
	 * @return Object    
	
	 *
	 * @author lishaozhang
	 * @createDate 2018年11月9日
	 */
	@RequestMapping("findAllCompactImgIsNull")
	@ResponseBody
	public Object findAllCompactImgIsNull (int page,int limit){
	    
		Map<String,Object> map =compactService.findAllCompactImgIsNull(page,limit);
	
		return JSONObject.toJSON(map); 	
	}
	  /**
	   * 
	  *
	   * @Title: findAllCompactImgIsNotNull
	  
	   * @description 分页查询所有已经传图片的合同表
	  *
	   * @param @param page
	   * @param @param limit
	   * @param @return 
	     
	   * @return Object    
	  
	   *
	   * @author lishaozhang
	   * @createDate 2018年11月9日
	   */
	  @RequestMapping("findAllCompactImgIsNotNull")
		@ResponseBody
		public Object findAllCompactImgIsNotNull (int page,int limit){
		    
			Map<String,Object> map =compactService.findAllCompactImgIsNotNull(page,limit);
		
			return JSONObject.toJSON(map); 	
		}
          
	  /**
	   * 
	  *
	   * @Title: deleatAliFile
	  
	   * @description 删除阿里云上的文件
	  *
	   * @param @param img_url
	   * @param @return 
	     
	   * @return Object    
	  
	   *
	   * @author lishaozhang
	   * @createDate 2018年11月22日
	   */
	    @RequestMapping("deleatAliFile")
		@ResponseBody
		public Object deleatAliFile (String img_url){
		    
			UpdateFile updateFile = new UpdateFile();
			Map<String,Object> map = new HashMap<>();
			try {
				map = updateFile.deleatFile(img_url);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return JSONObject.toJSON(map); 	
		}
	    
	    /**
	     * 
	    *
	     * @Title: fiandFiduciaryLoanByStatus
	    
	     * @description 查询待审核的信用贷报单
	    *
	     * @param @param status1
	     * @param @param status2
	     * @param @param page
	     * @param @param limit
	     * @param @return 
	       
	     * @return Object    
	    
	     *
	     * @author lishaozhang
	     * @createDate 2018年11月26日
	     */
	    @RequestMapping("fiandFiduciaryLoanByStatus")
		@ResponseBody
		public Object fiandFiduciaryLoanByStatus (@RequestParam(defaultValue="7")int status1,@RequestParam(defaultValue="-10")int status2,int page,int limit){
	    	Map<String,Object> map =compactService.fiandFiduciaryLoanByStatus(status1,status2,page,limit);
	    	return JSONObject.toJSON(map);
	    }
	    
	    /**
	     * 
	    *
	     * @Title: fiandHousePropertyMortgageByStatus
	    
	     * @description 查询待审核的房屋贷报单
	    *
	     * @param @param status1
	     * @param @param status2
	     * @param @param page
	     * @param @param limit
	     * @param @return 
	       
	     * @return Object    
	    
	     *
	     * @author lishaozhang
	     * @createDate 2018年11月26日
	     */
	    @RequestMapping("fiandHousePropertyMortgageByStatus")
		@ResponseBody
		public Object fiandHousePropertyMortgageByStatus (@RequestParam(defaultValue="7")int status1,@RequestParam(defaultValue="-10")int status2,int page,int limit){
	    
			Map<String,Object> map =compactService.fiandHousePropertyMortgageByStatus(status1,status2,page,limit);
	    	return JSONObject.toJSON(map);
	    }
	    
	    /**
	     * 
	    *
	     * @Title: fiand
	     * VehicleMortgageByStatus
	    
	     * @description 查询待审核的车辆贷报单
	    *
	     * @param @param status1
	     * @param @param status2
	     * @param @param page
	     * @param @param limit
	     * @param @return 
	       
	     * @return Object    
	    
	     *
	     * @author lishaozhang
	     * @createDate 2018年11月26日
	     */
	    @RequestMapping("fiandVehicleMortgageByStatus")
		@ResponseBody
		public Object fiandVehicleMortgageByStatus (@RequestParam(defaultValue="7")int status1,@RequestParam(defaultValue="-10")int status2,int page,int limit){
	    	Map<String,Object> map =compactService.fiandVehicleMortgageByStatus(status1,status2,page,limit);
	    	return JSONObject.toJSON(map);
	    }
	    
}