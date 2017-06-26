package com.tyust.dat.dao;

import com.tyust.dao.BaseJdbcDao;
import com.tyust.dat.protocol.RequestData;
import org.springframework.stereotype.Repository;

@Repository
public class DatCheckDataDao extends BaseJdbcDao {

	public int insert(RequestData data) throws Exception{
        String sql = " INSERT INTO DAT_CHECK_DATA (CHECK_NO, CHECK_TYPE, SITE_ID, EQUIP_ID, LINE, VEHICLE_NO, VEHICLE_TYPE, AXLES, TYRES, CHECK_RESULT, CHECK_BY, CHECK_TIME, SPEED, LIMIT_TOTAL, OVER_TOTAL, TOTAL, DESC_INFO, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] args = { 
        		data.getCheckNo(), data.getCheckType(), data.getSiteId(), data.getEquipId(), data.getLine(),
        		data.getVehicleNo(), data.getVehicleType(), data.getAxles(), data.getTyres(), data.getCheckResult(), 
        		data.getCheckBy(), data.getCheckTime(), data.getSpeed(), data.getLimitTotal(), data.getOverTotal(), data.getTotal(), data.getDescInfo(),
        		data.getCreateBy(), data.getCreateTime(), data.getUpdateBy(), data.getUpdateTime()
        };
        return super.getJdbcTemplate().update(sql, args);
	}
	
	public boolean exist(String checkNo){
		String sql = "SELECT COUNT(*) FROM DAT_CHECK_DATA DCD WHERE DCD.CHECK_NO = ? ";
        int count = super.getJdbcTemplate().queryForObject(sql.toString(), Integer.class, checkNo);
        if (count > 0) {
            return true;
        }
        return false;  
	}
	
	public int update(RequestData data) throws Exception{
        String sql = " UPDATE DAT_CHECK_DATA SET CHECK_TYPE = ?, SITE_ID = ?, EQUIP_ID = ?, LINE = ?, VEHICLE_NO = ?, VEHICLE_TYPE = ?, AXLES = ?, TYRES = ?, CHECK_RESULT = ?, CHECK_BY = ?, CHECK_TIME = ?, SPEED = ?, LIMIT_TOTAL = ?, OVER_TOTAL = ?, TOTAL = ?, DESC_INFO = ?, CREATE_BY = ?, CREATE_TIME = ?, UPDATE_BY = ?, UPDATE_TIME = ? WHERE CHECK_NO = ?)";
        Object[] args = { 
        		data.getCheckType(), data.getSiteId(), data.getEquipId(), data.getLine(),
        		data.getVehicleNo(), data.getVehicleType(), data.getAxles(), data.getTyres(), data.getCheckResult(), 
        		data.getCheckBy(), data.getCheckTime(), data.getSpeed(), data.getLimitTotal(), data.getOverTotal(), data.getTotal(), data.getDescInfo(),
        		data.getCreateBy(), data.getCreateTime(), data.getUpdateBy(), data.getUpdateTime(), data.getCheckNo()
        };
        return super.getJdbcTemplate().update(sql, args);
	}	
	
	
}
