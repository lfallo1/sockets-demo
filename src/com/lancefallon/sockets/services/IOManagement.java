package com.lancefallon.sockets.services;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IOManagement {

	private static final Logger logger = Logger.getLogger(IOManagement.class.getName());
	
	public void closeStreams(Closeable... streams){
		for(Closeable obj : streams){
			if(obj != null){
				try {
					logger.info("closing " + obj.toString());
					obj.close();
				} catch (IOException e) {
					logger.log(Level.WARNING, e.getMessage());
				}
			}
		}
	}
	
}
