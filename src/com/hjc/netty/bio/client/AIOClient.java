package com.hjc.netty.bio.client;

import com.hjc.netty.bio.handler.AsyncTimeServerHandler;

public class AIOClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 8999;
		AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler();
		new Thread(timeServer,"AIO").start();
	}

}
