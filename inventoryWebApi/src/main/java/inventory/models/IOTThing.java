package inventory.models;

import java.util.ArrayList;
import java.util.List;

public class IOTThing extends Hardware{
	
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

}
