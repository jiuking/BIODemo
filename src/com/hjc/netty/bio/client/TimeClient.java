package com.hjc.netty.bio.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
	
	public static void main(String[] args){
		int port = 8999;
		if(args.length>0 && args[0]!=null){
			try{
				port = Integer.valueOf(args[0]);
			}catch(NumberFormatException e){
				
			}
		}
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try{
			socket = new Socket("127.0.0.1", port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			out.println("QUERY TIME ORDER");
			System.out.println("Send order 2 server success");
			String resp = in.readLine();
			System.out.println("Now is "+resp);
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally {
			if(in != null){
				try{
					in.close();
					in = null;
				}catch(IOException ioe){
					ioe.printStackTrace();
				}
			}
			if(out != null){
				out.close();
				out = null;
			}if(socket != null){
				try{
					socket.close();
					socket = null;
				}catch(IOException ioe){
					ioe.printStackTrace();
				}
			}
		}
	}
}
