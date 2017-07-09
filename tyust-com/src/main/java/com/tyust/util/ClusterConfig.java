package com.tyust.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
//启动缓存配置
@ComponentScan("bhz")
@PropertySource("classpath:redis.properties")
public class ClusterConfig {

	@Autowired
	private Environment environment;
	
	@Bean
	public JedisCluster getRedisCluster(){
	    Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
	    jedisClusterNode.add(new HostAndPort(environment.getProperty("redis.cluster.nodes1"), Integer.parseInt(environment.getProperty("redis.cluster.port1"))));
	    jedisClusterNode.add(new HostAndPort(environment.getProperty("redis.cluster.nodes2"), Integer.parseInt(environment.getProperty("redis.cluster.port2"))));
	    jedisClusterNode.add(new HostAndPort(environment.getProperty("redis.cluster.nodes3"), Integer.parseInt(environment.getProperty("redis.cluster.port3"))));
	    jedisClusterNode.add(new HostAndPort(environment.getProperty("redis.cluster.nodes4"), Integer.parseInt(environment.getProperty("redis.cluster.port4"))));
	    jedisClusterNode.add(new HostAndPort(environment.getProperty("redis.cluster.nodes5"), Integer.parseInt(environment.getProperty("redis.cluster.port5"))));
	    jedisClusterNode.add(new HostAndPort(environment.getProperty("redis.cluster.nodes6"), Integer.parseInt(environment.getProperty("redis.cluster.port6"))));
	    JedisPoolConfig cfg = new JedisPoolConfig();
	    cfg.setMaxTotal(Integer.parseInt(environment.getProperty("redis.cluster.config.max-total")));
	    cfg.setMaxIdle(Integer.parseInt(environment.getProperty("redis.cluster.config.max-idle")));
	    cfg.setMaxWaitMillis(Integer.parseInt(environment.getProperty("redis.cluster.config.max-waitmillis")));
	    cfg.setTestOnBorrow(Boolean.parseBoolean(environment.getProperty("redis.cluster.config.onborrow"))); 
	    JedisCluster jc = new JedisCluster(jedisClusterNode, Integer.parseInt(environment.getProperty("redis.cluster.timeout")), Integer.parseInt(environment.getProperty("redis.cluster.max-redirections")), cfg);
	    return jc;
	}
	
}
