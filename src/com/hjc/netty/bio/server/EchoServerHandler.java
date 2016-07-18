package com.hjc.netty.bio.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EchoServerHandler extends ChannelHandlerAdapter {

	int counter = 0;
	
	public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
		// TODO Auto-generated method stub
		String body = (String)msg;
		System.out.println("This is "+ ++counter +"times receive client:["+
		body +"]");
		body += "$_";
		ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
		ctx.writeAndFlush(echo);
	}
	
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
		cause.printStackTrace();
		ctx.close();
	}
}
