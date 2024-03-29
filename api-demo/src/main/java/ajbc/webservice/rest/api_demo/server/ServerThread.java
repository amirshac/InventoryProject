package ajbc.webservice.rest.api_demo.server;

import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ServerThread extends Thread{
	protected final int PORT;
	protected ExecutorService executorService;
	protected boolean serverActive;

	public ServerThread(int port) {
		this.PORT = port;
		executorService = Executors.newCachedThreadPool();
		serverActive = true;
	}
	
	@Override
	public void run() {
		try (ServerSocket serverSocket = new ServerSocket(PORT);){
			
			System.out.println("Inventory TCP server started on port " + PORT);
	
			while(serverActive) {
				Socket clientSocket = serverSocket.accept();
				SocketThread newSessionThread = new SocketThread(clientSocket);
				executorService.execute(newSessionThread);
			}
			
		}catch (IOException e) {
			System.err.println("Failed to start server on port " + PORT);
			e.printStackTrace();	
		}
	}
	
	public void kill() {
		try {
			executorService.shutdown();
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("Error shutting down server");
			e.printStackTrace();	
		}
	}
	
}
