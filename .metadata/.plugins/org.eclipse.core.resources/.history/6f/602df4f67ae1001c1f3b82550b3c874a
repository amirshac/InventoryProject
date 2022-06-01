package inventory.models;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import Utils.GsonUtil;

public class InventoryReportClient {
	private final static String SERVER_NAME = "localhost";
	private final static int SERVER_PORT = 8090;	
	
	protected Socket clientSocket;
	protected PrintWriter writer;
	
	IOTThing iot;
	
	public InventoryReportClient() {}
	
	public InventoryReportClient(IOTThing iot){
		setIot(iot);
	}
	
	public void setIot(IOTThing iot) {
		this.iot = iot;
	}
	
	public void connect() { 		
		try (Socket clientSocket = new Socket(SERVER_NAME, SERVER_PORT)) {
			this.clientSocket = clientSocket;
			System.out.println("Connected to server");
			writer = new PrintWriter(clientSocket.getOutputStream());
			
			
		} catch (IOException e) {
			System.out.println("Can't connect to server");
			e.printStackTrace();
		}
	}
	
	public void closeAllConnections() {
		if (writer!=null)
			writer.close();
		
		if (clientSocket!=null)
			try {
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void transmitReportsPeriodically() {
		String reportString = GsonUtil.toJsonString(iot);
		writer.println(reportString);
		System.out.println("Sent report\n" + reportString);
	}
}
