package com.tyust.dat.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

public class NettyServer {
	
	private static class SingletonHolder {
		static final NettyServer instance = new NettyServer();
	}
	
	public static NettyServer getInstance(){
		return SingletonHolder.instance;
	}
	
	private EventLoopGroup pGroup;
	
	private EventLoopGroup cGroup;
	
	private ServerBootstrap serverBootstrap;
	
	private ChannelFuture cf;
	
	private NettyServer(){
		pGroup = new NioEventLoopGroup();
		cGroup = new NioEventLoopGroup();
		serverBootstrap = new ServerBootstrap();
		serverBootstrap.group(pGroup, cGroup)
		 .channel(NioServerSocketChannel.class)
		 .option(ChannelOption.SO_BACKLOG, 1024)
		 //设置日志
		 .handler(new LoggingHandler(LogLevel.INFO))
		 .childHandler(new ChannelInitializer<SocketChannel>() {
			protected void initChannel(SocketChannel sc) throws Exception {
				sc.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
				sc.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
				sc.pipeline().addLast(new ReadTimeoutHandler(60));
				sc.pipeline().addLast(new NettyServerHandler());
			}
		});		
	}
	
	public void start(){
		try {
			this.cf = serverBootstrap.bind(8765).sync();
			System.out.println("netty服务器启动..");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public ChannelFuture getChannelFuture(){
		return this.cf;
	}
	
	public void close(){
		try {
			this.cf.channel().closeFuture().sync();
			this.pGroup.shutdownGracefully();
			this.cGroup.shutdownGracefully();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
