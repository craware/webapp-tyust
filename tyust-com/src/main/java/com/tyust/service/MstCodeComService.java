package com.tyust.service;

import java.util.List;

import com.tyust.dao.MstCodeComDao;
import com.tyust.util.FastJsonConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCluster;

import com.alibaba.fastjson.JSONObject;

@Service
public class MstCodeComService {

    /** 缓存标识前缀 */
    private static final String CACHE_ID = "MST_CODE";
    
    @Autowired
	private MstCodeComDao mstCodeComDao;

    @Autowired
    private JedisCluster jedisCluster;
	
	public List<JSONObject> getTypeList(String type){
		String ret = jedisCluster.hget(CACHE_ID, type);
		if(ret == null){
			System.out.println("----查询数据库----");
			List<JSONObject> list = this.mstCodeComDao.getTypeList(type);
			jedisCluster.hset(CACHE_ID, type, list.toString());
			ret = list.toString();
		}
		return FastJsonConvert.convertJSONToArray(ret, JSONObject.class);
	}
	
	//清空指定的hash key 自己实现...
	public void clearTypeList(String type){
		
	}
	
	
	
	
}
