package com.hjc.netty.bio.handler;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable {

	private int port;
	CountDownLatch latch;
	AsynchronousServerSocketChannel asynchronousServerSocketChannel;
	
	public AsyncTimeServerHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public AsyncTimeServerHandler(int port) {
		// TODO Auto-generated constructor stub
		this.port = port;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		latch = new CountDownLatch(1);
		doAccept();
		try{
			latch.await();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	private void doAccept() {
		// TODO Auto-generated method stub
		asynchronousServerSocketChannel.accept(this,
				new AcceptCompletionHandler());
	}

}
