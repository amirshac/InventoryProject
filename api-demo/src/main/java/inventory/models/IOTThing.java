package inventory.models;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class IOTThing extends Hardware{
	
	private final static String SERVER_NAME = "localhost";
	private final static int SERVER_PORT = 8080;
	
	
	protected List<Device> devices;
	
	public IOTThing() {}
	
	public IOTThing(HardwareType type, String model, String manufacturer) {
		super(type,model,manufacturer);
		devices = new ArrayList<Device>();
	}
	
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	
	public List<Device> getDevices(){
		return this.devices;
	}
	
	public void addDevice(Device device) {
		this.devices.add(device);
	}
	
	public Device removeDevice(int index) {
		if (index<0 || index > devices.size() ) return null;
		
		return(devices.remove(index));
	}
	
	public Device removeLastDevice() {
		if (devices.isEmpty()) return null;
		
		return (devices.remove(devices.size()-1));
	}
	
	public void connect() {
			try {
				Socket clientSocket = new Socket(SERVER_NAME, SERVER_PORT);
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
			} catch (IOException e) {
				System.out.println("Can't connect to server");
				e.printStackTrace();
			}
			System.out.println("Connected to server");
	}

	@Override
	public String toString() {
		return super.toString() + "IOTThing [devices=" + devices + "]";
	}
	
	

}
