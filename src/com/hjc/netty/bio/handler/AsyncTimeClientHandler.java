package com.hjc.netty.bio.handler;

import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeClientHandler implements CompletionHandler<Void, AsyncTimeClientHandler>,Runnable {

	private AsynchronousSocketChannel client;
	private String host;
	private int port;
	private CountDownLatch latch;
	
	@Override
	public void run() {
		
	}

	@Override
	public void completed(Void result, AsyncTimeClientHandler attachment) {
		
	}

	@Override
	public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
		
	}

}
