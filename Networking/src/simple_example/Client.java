package simple_example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
	
	public static void main(String ... args) {
		try {
			Socket socket = new Socket("localhost", 9000);
			ObjectOutputStream outputToServer = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inputFromServer = new ObjectInputStream(socket.getInputStream());
			while (true) {
				ChatMessage chatMessage = (ChatMessage) inputFromServer.readObject();
				if (chatMessage == null) {
					return;
				}
				System.out.println("Reading form the server...");
				String str = chatMessage.getId() + "\t" + chatMessage.getName() + "\t" + chatMessage.getMessage();
				System.out.println(str);
				
				switch (chatMessage.getId()) {
				case 0:
					System.out.println(chatMessage.getName() + ": " + chatMessage.getMessage());
					break;
				case 1:
					System.out.println("Type 1");
					break;
				case 2:
					System.out.println("Type 2");
					break;
				}
			}
			
		} catch (IOException e) {
			System.out.println("Socket couldn't connect.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't parse data from server.");
			e.printStackTrace();
		}
		
	}
}
