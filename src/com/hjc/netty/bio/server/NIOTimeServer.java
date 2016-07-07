package com.hjc.netty.bio.server;

public class NIOTimeServer {
	
	public static void main(String[] args){
		int port = 8999;
		if(args != null && args.length>0){
			try{
				port = Integer.valueOf(args[0]);
				
			}catch(NumberFormatException e){
				
			}
			MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
			new Thread(timeServer,"NIO").start();;
		}
	}
}
