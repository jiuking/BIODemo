package com.hjc.netty.bio.handler;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class NIOClinetHandler implements  Runnable{
	private String host;
	private int port;
	private Selector selector;
	private SocketChannel socketChannel;
	private volatile boolean stop;
	
	public NIOClinetHandler(){
		
	}
	public NIOClinetHandler(String host,int port){
		this.host = null == host?"127.0.0.1":host;
		this.port = port;
		try{
			selector = Selector.open();
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
		}catch(IOException ioe){
			ioe.printStackTrace();
			System.exit(1);
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
