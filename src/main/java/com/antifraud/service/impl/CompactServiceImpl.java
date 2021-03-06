package com.antifraud.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.antifraud.dao.CompactDao;
import com.antifraud.dao.FiduciaryLoanDao;
import com.antifraud.dao.HousePropertyMortgageDao;
import com.antifraud.dao.VehicleMortgageDao;
import com.antifraud.entity.Compact;
import com.antifraud.entity.FiduciaryLoan;
import com.antifraud.entity.HousePropertyMortgage;
import com.antifraud.entity.User;
import com.antifraud.entity.VehicleMortgage;
import com.antifraud.entityVO.VehicleMortgageVo;
import com.antifraud.service.CompactService;
import com.antifraud.utils.UpdateFile;
@Service
public class CompactServiceImpl implements CompactService {
	
	//设置将文件要上传到的位置
	
	
    @Autowired
	 private CompactDao compactDao;
    
    @Autowired
    private FiduciaryLoanDao  fiduciaryLoanDao;
    
    @Autowired
    private HousePropertyMortgageDao housePropertyMortgageDao;
    
    @Autowired
    private VehicleMortgageDao vehicleMortgageDao;
    
	@Override
	public int insertCompact(Compact compact) {
		 
		return compactDao.insertCompact(compact);
	}

	@Override
	public FiduciaryLoan findByEntry_number(String entry_number) {
		
		return compactDao.findByEntry_number(entry_number);
	}

	@Override
	public Compact findLastCompact() {
		
		return compactDao.findLastCompact();
	}

	@Override
	public Map upLoadCompact(String entry_number, List<MultipartFile> files ,String reamker) {
		//根据报单编号查询相应的合同数据
		 List<Compact> compactList = compactDao.findCompactByEntry_number(entry_number);
		for (Compact compact : compactList) {
		}
		 Compact compact =compactList.get(0);
		 //合同编号
		String contract_id = compact.getContract_id();
		
		//报单编号
		String report_id = compact.getReport_id();
		
		//获取当前登陆用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		Long user_id = user.getId();
		
		
		 
	     //当前时间格式化
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		 
	 
		for (int i = 0; i < files.size(); i++) {
					
			Compact oldCompact = compactDao.findOneCompactByEntry_number(entry_number);
			//将当前报单未插入图片的数据修改
			if(oldCompact != null ){
				
				
			MultipartFile file = files.get(i);	
			  UpdateFile updateFile = new UpdateFile();
			  
			  //url 要上传到的地址 fileName这里以UUID值命名
			  String fileName = contract_id+i;
			  try {
				  //上传成功返回 路径 和 后缀
				Map<String, String> map = updateFile.update(file);
				
				//获取后缀路径
				String img_format = map.get("suffix");
				String img_url = map.get("Path");
				//文件类型验证 如果文件不符合要求返回错误信息   （也可以忽略掉保存下一跳数据）
				if(!"psdjpgpngsvg".contains(img_format)){
					Map map2 = new HashMap<>();
					map2.put("code", -1);
					map2.put("msg", "文件类型需要是psd jpg png svg 格式的图片");
					
					return map2;
				}
				
				Date date = new Date();			
			//	String create_time = simpleDateFormat.format(date);
			    
				oldCompact.setUser_id(user_id);
				oldCompact.setCreate_time(date);
				oldCompact.setRemark(reamker);
				oldCompact.setImg_format(img_format);
				oldCompact.setImg_url(img_url);
				
				long id = oldCompact.getId();
				compactDao.updateCompactByid(oldCompact);
			} catch (Exception e) {
				e.printStackTrace();
				Map map = new HashMap<>();
				map.put("code", -1);
				map.put("msg", "保存失败");
				map.put("count", null);
				map.put("data",null);
				return map;
			//	e.printStackTrace();
			}
			  
			  
			    
			  
			}else{
			
				System.out.println("非空图片");
			//其余图片照常保存
			MultipartFile file = files.get(i);	
			
			  UpdateFile updateFile = new UpdateFile();
			  
			
			  try {
				  //上传成功返回 路径 和 后缀
				Map<String, String> map = updateFile.update(file);
				
				//获取后缀路径
				String img_format = map.get("suffix");
				System.out.println("img_format"+img_format);
				String img_url = map.get("Path");
				//文件类型验证
				if(!"psdjpgpngsvg".contains(img_format)){
					Map map2 = new HashMap<>();
					map2.put("code", -1);
					map2.put("msg", "文件类型需要是psd jpg png svg 格式的图片");
					map2.put("count", null);
					map2.put("data",null);
					return map2;
				}
				
				Date date = new Date();			
			//	String create_time = simpleDateFormat.format(date);
				
				//将信息保存到数据库
				Compact compact2 = new Compact();
			    
				compact2.setUser_id(user_id);
				compact2.setCreate_time(date);
				compact2.setRemark(reamker);
				compact2.setImg_format(img_format);
				compact2.setImg_url(img_url);
				compact2.setContract_id(contract_id);
				compact2.setReport_id(report_id);
				
				int insertCompact = compactDao.insertCompact(compact2);
				System.out.println(insertCompact);
			} catch (Exception e) {
				e.printStackTrace();
				Map map = new HashMap<>();
				map.put("code", -1);
				map.put("msg", "保存失败");
				map.put("count", null);
				map.put("data",null);
				e.printStackTrace();
				return map;
			}
			
			
			
			
		}
		
		}
		Map map = new HashMap<>();
		map.put("code", 1);
		map.put("msg", "保存成功");
		map.put("count", null);
		map.put("data",null);
		return map;	
	
	}

	@Override
	public int updateCompactByContract_id(Compact compact) {
		
		return compactDao.updateCompactByid(compact);
	}

	@Override
	public List<Compact> findCompactByEntry_number(String Entry_number) {
		
		return compactDao.findCompactByEntry_number(Entry_number);
	}

	@Override
	public List<Compact> findAllCompact(int page,int limit) {
		int star =(page - 1) * limit;
	
		return compactDao.findAllCompact(star,limit);
	}

	@Override
	public int deleteCompactByReport_id(String report_id) {
		
		return compactDao.deleteCompactByReport_id(report_id);
	}

	@Override
	public int deleteCompactByid(Long id) {
		
		return compactDao.deleteCompactByid(id);
	}

	@Override
	public Map findallForCamapte(int page, int limit) {
		Map map =new HashMap<>();
		
		int star = (page - 1) * limit;				
		List<FiduciaryLoan> camapteList = fiduciaryLoanDao.findallForCamapte(star, limit);
		
		if(camapteList.size()>=1){
			map.put("code", 1);
			map.put("msg", "查询成功");
			map.put("count", fiduciaryLoanDao.findallForCamaptecount());
			map.put("data", camapteList);
			return map;
		}else {
			map.put("code", -1);
			map.put("msg", "数据库中目前没有符合条件的数据");
			map.put("count", camapteList.size());
			map.put("data", camapteList);
			return map;
		}
	}

	@Override
	public Map findAllHousePropertyMortgageForCompact(int page, int limit) {
		
     Map map =new HashMap<>();
		
		int star = (page - 1) * limit;				
		 List<HousePropertyMortgage> HousePropertyMortgageList = housePropertyMortgageDao.findAllHousePropertyMortgageForCompact(star, limit);
		
		if(HousePropertyMortgageList.size()>=1){
			map.put("code", 1);
			map.put("msg", "查询成功");
			map.put("count", housePropertyMortgageDao.findAllHousePropertyMortgageForCompactCount());
			map.put("data", HousePropertyMortgageList);
			return map;
		}else {
			map.put("code", -1);
			map.put("msg", "数据库中目前没有符合条件的数据");
			map.put("count", HousePropertyMortgageList.size());
			map.put("data", HousePropertyMortgageList);
			return map;
		}
	}

	@Override
	public Map findAllVehicleMortgageForCamapte(int page, int limit) {
		  Map map =new HashMap<>();
			
			int star = (page - 1) * limit;				
			  List<VehicleMortgageVo> mortgageList = vehicleMortgageDao.findAllVehicleMortgageForCamapte(star, limit);
			
			if(mortgageList.size()>=1){
				map.put("code", 1);
				map.put("msg", "查询成功");
				map.put("count", vehicleMortgageDao.findAllVehicleMortgageForCamapteCount());
				map.put("data", mortgageList);
				return map;
			}else {
				map.put("code", -1);
				map.put("msg", "数据库中目前没有符合条件的数据");
				map.put("count", mortgageList.size());
				map.put("data", mortgageList);
				return map;
			}
	}

	@Override
	public Map findAllCompactImgIsNull(int page, int limit) {
		 Map map =new HashMap<>();
			
			int star = (page - 1) * limit;				
			   List<Compact> compactList = compactDao.findAllCompactImgIsNull(star, limit);
			
			if(compactList.size()>=1){
				map.put("code", 1);
				map.put("msg", "查询成功");
				map.put("count", compactDao.findAllCompactImgIsNullCount());
				map.put("data", compactList);
				return map;
			}else {
				map.put("code", -1);
				map.put("msg", "数据库中目前没有符合条件的数据");
				map.put("count", compactDao.findAllCompactImgIsNullCount());
				map.put("data", compactList);
				return map;
			}
	}

	@Override
	public Map findAllCompactImgIsNotNull(int page, int limit) {
		Map map =new HashMap<>();
		
		int star = (page - 1) * limit;				
		   List<Compact> compactList = compactDao.findAllCompactImgIsNotNull(star, limit);
		  
		if(compactList.size()>=1){
			map.put("code", 1);
			map.put("msg", "查询成功");
			map.put("count", compactDao.findAllCompactImgIsNotNullCount().size());
			map.put("data", compactList);
			return map;
		}else {
			map.put("code", -1);
			map.put("msg", "数据库中目前没有符合条件的数据");
			map.put("count", compactList.size());
			map.put("data", compactList);
			return map;
		}
	}

	@Override
	public Map fiandFiduciaryLoanByStatus(int status1, int status2, int page, int limit) {
		
		int star = (page - 1) * limit;
		List<FiduciaryLoan> fiduciaryList = fiduciaryLoanDao.fiandFiduciaryLoanByStatus(status1, status2, star, limit);
		Map map =new HashMap<>();
		
		if(fiduciaryList.size()>=1){
			map.put("code", 1);
			map.put("msg", "查询成功");
			map.put("count", fiduciaryLoanDao.fiandFiduciaryLoanByStatusCount(status1, status2));
			map.put("data", fiduciaryList);
			return map;
		}else {
			map.put("code", -1);
			map.put("msg", "数据库中目前没有符合条件的数据");
			map.put("count", fiduciaryLoanDao.fiandFiduciaryLoanByStatusCount(status1, status2));
			map.put("data", fiduciaryList);
			return map;
		}
		
	}

	@Override
	public Map fiandHousePropertyMortgageByStatus(int status1, int status2, int page, int limit) {
		
		int star = (page - 1) * limit;
		List<HousePropertyMortgage> housePropertyMortgageList = housePropertyMortgageDao.fiandHousePropertyMortgageByStatus(status1, status2, star, limit);
		
        Map map =new HashMap<>();
		
		if(housePropertyMortgageList.size()>=1){
			map.put("code", 1);
			map.put("msg", "查询成功");
			map.put("count", housePropertyMortgageDao.fiandHousePropertyMortgageByStatusCount(status1, status2));
			map.put("data", housePropertyMortgageList);
			return map;
		}else {
			map.put("code", -1);
			map.put("msg", "数据库中目前没有符合条件的数据");
			map.put("count", housePropertyMortgageDao.fiandHousePropertyMortgageByStatusCount(status1, status2));
			map.put("data", housePropertyMortgageList);
			return map;
		}
	}

	@Override
	public Map fiandVehicleMortgageByStatus(int status1, int status2, int page, int limit) {
		
		int star = (page - 1) * limit;
		  List<VehicleMortgage> VehicleMortgageList = vehicleMortgageDao.fiandVehicleMortgageByStatus(status1, status2, star, limit);
		
        Map map =new HashMap<>();
		
		if(VehicleMortgageList.size()>=1){
			map.put("code", 1);
			map.put("msg", "查询成功");
			map.put("count", vehicleMortgageDao.fiandVehicleMortgageByStatusCount(status1, status2));
			map.put("data", VehicleMortgageList);
			return map;
		}else {
			map.put("code", -1);
			map.put("msg", "数据库中目前没有符合条件的数据");
			map.put("count", vehicleMortgageDao.fiandVehicleMortgageByStatusCount(status1, status2));
			map.put("data", VehicleMortgageList);
			return map;
		}
		
	}
		 

}
