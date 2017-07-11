package com.lancefallon.sockets.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import com.lancefallon.sockets.services.IOManagement;

public class Driver {

	public static void main(String[] args) {
		String text = "", response = "";
		Scanner userInput = null, readFromSocket = null;
		Socket s = null;
		try{
			userInput = new Scanner(System.in);
			s = new Socket("127.0.0.1", 1342);
			readFromSocket = new Scanner(s.getInputStream());
			System.out.println("Starting chat...");
			while(!text.toLowerCase().equals("quit")){
				text = userInput.nextLine();
				PrintStream printToSocket = new PrintStream(s.getOutputStream());
				printToSocket.println(text);
				response = readFromSocket.nextLine();
				System.out.println(response);
			}
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			new IOManagement().closeStreams(userInput, readFromSocket, s);
		}
	}

}
