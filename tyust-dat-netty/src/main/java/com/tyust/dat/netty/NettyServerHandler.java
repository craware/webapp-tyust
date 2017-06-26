package com.tyust.dat.netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.tyust.dat.dao.DatCheckDataDao;
import com.tyust.dat.listener.ApplicationFactory;
import com.tyust.dat.protocol.RequestData;
import com.tyust.dat.protocol.ResponseData;

@Component
public class NettyServerHandler extends ChannelHandlerAdapter{

	//@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

	}

	//@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		//获取请求数据对象
		RequestData requestData = (RequestData)msg;
		
		//通用类:ContextLoader
		ApplicationContext application = ApplicationFactory.getContext();
		DatCheckDataDao datCheckDataDao = (DatCheckDataDao) application.getBean("datCheckDataDao");	
		
		//返回数据对象
		ResponseData responseData = new ResponseData();
		try {
			if(!datCheckDataDao.exist(requestData.getCheckNo())){
				datCheckDataDao.insert(requestData);
			}
			else {
				datCheckDataDao.update(requestData);
			}
			System.out.println("中心服务器端收到: " +  requestData.getCheckNo());
			responseData.setCheckNo(requestData.getCheckNo());
			responseData.setSuccess(true);
			responseData.setMessage("数据交换成功!");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseData.setCheckNo(requestData.getCheckNo());
			responseData.setSuccess(false);
			responseData.setMessage("数据交换失败!");
		}
		ctx.writeAndFlush(responseData);
	}

	//@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		
	}

	
	
}
