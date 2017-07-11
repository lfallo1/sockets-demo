package com.lancefallon.sockets.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.lancefallon.sockets.services.IOManagement;

public class Driver {
	
	public static void main(String[] args) {
		String message = "", response = "";
		ServerSocket serverSocket = null;
		Socket socket = null;
		Scanner readFromSocketScanner = null, userInput = null;
		try{
			serverSocket = new ServerSocket(1342);
			socket = serverSocket.accept();
			readFromSocketScanner = new Scanner(socket.getInputStream());
			userInput = new Scanner(System.in);
			while(!response.toLowerCase().equals("quit")){
				message = readFromSocketScanner.nextLine();
				System.out.println(message);
				response = userInput.nextLine();
				PrintStream writeToSocket = new PrintStream(socket.getOutputStream());
				writeToSocket.println(response);
			}
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			new IOManagement().closeStreams(serverSocket, socket, readFromSocketScanner, userInput);
		}
	}
}
