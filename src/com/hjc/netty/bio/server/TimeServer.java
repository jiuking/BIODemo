package com.hjc.netty.bio.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.hjc.netty.bio.handler.TimeServerHandler;
import com.hjc.netty.bio.handler.TimeServerHandlerExcutePool;

public class TimeServer{
	
	public static final int port = 8999;
	public static void main(String[] args) throws IOException{
		if(args.length>0&&args[0] != null){
			try{
				
			}catch(NumberFormatException e){
				
			}
		}
		ServerSocket server = null;
		try{
			server = new ServerSocket(port);
			System.out.println("start time server!");
			Socket socket = null;
			TimeServerHandlerExcutePool singleExecute = new TimeServerHandlerExcutePool(50,1000);
			while(true){
				socket = server.accept();
				singleExecute.excute(new TimeServerHandler(socket));
//				new Thread(new TimeServerHandler(socket)).start();
			}
		}finally{
			if(server != null){
				System.out.println("shutdown server");
				server.close();
			}
		}
	}
}
