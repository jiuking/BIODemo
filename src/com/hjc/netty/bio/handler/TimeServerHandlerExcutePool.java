package com.hjc.netty.bio.handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimeServerHandlerExcutePool {
	
	private ExecutorService executor;
	
	public TimeServerHandlerExcutePool(){
		
	}
	
	public TimeServerHandlerExcutePool(int maxPoolSize,int queueSize){
		executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 
				120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
		
	}
	
	public void excute(Runnable obj){
		executor.execute(obj);
	}
	
}
