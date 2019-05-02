package simple_example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket listener = new ServerSocket(9000);
			while ( true ) {
				System.out.println("Waiting for client...");
				Socket socket = listener.accept();
				ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream inpoutFromClient = new ObjectInputStream(socket.getInputStream());
				ChatMessage chatMessage = new ChatMessage(0, "Adam", "Hello");
				outputToClient.writeObject(chatMessage);
				outputToClient.flush();
				System.out.println("Sending a chat message...");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
