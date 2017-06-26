package com.tyust.dat.protocol;

import java.io.Serializable;
import java.util.Date;

public class RequestData implements Serializable {
	private static final long  SerialVersionUID = 2L;
	
    private String checkNo;

    private String checkType;

    private String siteId;

    private String equipId;

    private String line;

    private String vehicleNo;

    private String vehicleType;

    private Integer axles;

    private Integer tyres;

    private String checkResult;

    private String checkBy;

    private Date checkTime;

    private Double speed;
    
    private Integer limitTotal;
    
    private Integer overTotal;

    private Integer total;

    private String descInfo;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo == null ? null : checkNo.trim();
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType == null ? null : checkType.trim();
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId == null ? null : siteId.trim();
    }

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId == null ? null : equipId.trim();
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line == null ? null : line.trim();
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo == null ? null : vehicleNo.trim();
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType == null ? null : vehicleType.trim();
    }

    public Integer getAxles() {
        return axles;
    }

    public void setAxles(Integer axles) {
        this.axles = axles;
    }

    public Integer getTyres() {
        return tyres;
    }

    public void setTyres(Integer tyres) {
        this.tyres = tyres;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult == null ? null : checkResult.trim();
    }

    public String getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(String checkBy) {
        this.checkBy = checkBy == null ? null : checkBy.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getLimitTotal() {
		return limitTotal;
	}

	public void setLimitTotal(Integer limitTotal) {
		this.limitTotal = limitTotal;
	}

	public Integer getOverTotal() {
		return overTotal;
	}

	public void setOverTotal(Integer overTotal) {
		this.overTotal = overTotal;
	}

	public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo == null ? null : descInfo.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
