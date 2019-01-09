package com.antifraud.entity;

import java.util.Date;

public class Photo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_photo.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_photo.report_id
     *
     * @mbggenerated
     */
    private String report_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_photo.img_url
     *
     * @mbggenerated
     */
    private String img_url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_photo.img_format
     *
     * @mbggenerated
     */
    private String img_format;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_photo.bussness_type
     *
     * @mbggenerated
     */
    private Byte bussness_type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_photo.create_time
     *
     * @mbggenerated
     */
    private Date create_time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_photo.update_time
     *
     * @mbggenerated
     */
    private Date update_time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_photo.id
     *
     * @return the value of t_photo.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_photo.id
     *
     * @param id the value for t_photo.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_photo.report_id
     *
     * @return the value of t_photo.report_id
     *
     * @mbggenerated
     */
    public String getReport_id() {
        return report_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_photo.report_id
     *
     * @param report_id the value for t_photo.report_id
     *
     * @mbggenerated
     */
    public void setReport_id(String report_id) {
        this.report_id = report_id == null ? null : report_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_photo.img_url
     *
     * @return the value of t_photo.img_url
     *
     * @mbggenerated
     */
    public String getImg_url() {
        return img_url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_photo.img_url
     *
     * @param img_url the value for t_photo.img_url
     *
     * @mbggenerated
     */
    public void setImg_url(String img_url) {
        this.img_url = img_url == null ? null : img_url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_photo.img_format
     *
     * @return the value of t_photo.img_format
     *
     * @mbggenerated
     */
    public String getImg_format() {
        return img_format;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_photo.img_format
     *
     * @param img_format the value for t_photo.img_format
     *
     * @mbggenerated
     */
    public void setImg_format(String img_format) {
        this.img_format = img_format == null ? null : img_format.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_photo.bussness_type
     *
     * @return the value of t_photo.bussness_type
     *
     * @mbggenerated
     */
    public Byte getBussness_type() {
        return bussness_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_photo.bussness_type
     *
     * @param bussness_type the value for t_photo.bussness_type
     *
     * @mbggenerated
     */
    public void setBussness_type(Byte bussness_type) {
        this.bussness_type = bussness_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_photo.create_time
     *
     * @return the value of t_photo.create_time
     *
     * @mbggenerated
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_photo.create_time
     *
     * @param create_time the value for t_photo.create_time
     *
     * @mbggenerated
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_photo.update_time
     *
     * @return the value of t_photo.update_time
     *
     * @mbggenerated
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_photo.update_time
     *
     * @param update_time the value for t_photo.update_time
     *
     * @mbggenerated
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}