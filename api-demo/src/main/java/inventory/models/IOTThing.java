package inventory.models;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class IotThing extends Hardware{
	
	
	protected List<Device> devices;
	
	public IotThing() {}
	
	public IotThing(HardwareType type, String model, String manufacturer) {
		super(type,model,manufacturer);
		devices = new ArrayList<Device>();
	}
	
	public IotThing(String uuidString, HardwareType type, String model, String manufacturer) {
		super(uuidString, type ,model,manufacturer);
		devices = new ArrayList<Device>();
	}
	
	public IotThing(byte[] uuidBytes, HardwareType type, String model, String manufacturer) {
		super(uuidBytes, type ,model,manufacturer);
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
	
	public void clearDevices() {
		devices.clear();
	}
	
	@Override
	public String toString() {
		return super.toString() + "IOTThing [devices=" + devices + "]";
	}
	

}
