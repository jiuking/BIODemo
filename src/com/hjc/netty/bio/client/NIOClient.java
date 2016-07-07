package com.hjc.netty.bio.client;

import com.hjc.netty.bio.handler.NIOClinetHandler;

public class NIOClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 8999;
		try{
			if(args != null && args.length >0){
				port = Integer.valueOf(args[0]);
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		new Thread(new NIOClinetHandler("127.0.0.1",port),"NIO").start();
	}

}
