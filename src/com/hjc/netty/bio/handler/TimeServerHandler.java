package com.hjc.netty.bio.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable{

	private Socket socket;
	public TimeServerHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public TimeServerHandler(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader in = null;
		PrintWriter out = null;
		try{
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(),true);
			String currentTime = null;
			String body = null;
			while(true){
				body = in.readLine();
				if(body== null){
					break;
				}
				currentTime = "QUERY TIME ORDER".equals(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
				out.println(currentTime);
			}
		}catch(Exception e){
			if(in!=null){
				try{
					in.close();
				}catch(IOException ioe){
					ioe.printStackTrace();
				}
			}
			if(out != null){
				out.close();
				out = null;
			}
			if(this.socket != null){
				try{
					this.socket.close();
				}catch(IOException ioe){
					ioe.printStackTrace();
				}
				this.socket = null;
			}
		}finally{
			
		}
	}

}
