package inventory.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

import Utils.GsonUtil;
import inventory.models.IotThing;

public class InventoryReportClient implements Runnable{
	//private static final long REPORT_SLEEP_DELAY = 10000;
	private final static String SERVER_NAME = "localhost";
	private final static int SERVER_PORT = 9090;	
	
	protected Socket clientSocket;
	protected PrintWriter writer;
	
	protected IotThing iot;
	protected boolean clientActive;
	
	protected Gson gson;
	
	public InventoryReportClient() {}
	
	public InventoryReportClient(IotThing iot){
		setIot(iot);
		clientActive = true;
		gson = new Gson();
	}
	
	public void setIot(IotThing iot) {
		this.iot = iot;
	}
	
	public IotThing getIot() {
		return this.iot;
	}
	
	public void connect() { 		
		try {
			clientSocket = new Socket(SERVER_NAME, SERVER_PORT);
			
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
				System.out.println(Thread.currentThread().getName() + " closed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void transmitReportsPeriodically() {
		String reportString = gson.toJson(iot);
		writer.println(reportString);
		System.out.println("Sent report\n" + reportString);

	}
	
	
	
	@Override
	public void run() {
		if (clientSocket==null)
			connect();
		
		transmitReportsPeriodically();	
		
		closeAllConnections();
	}
}
