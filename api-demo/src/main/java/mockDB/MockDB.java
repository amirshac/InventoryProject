package mockDB;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import inventory.models.Device;
import inventory.models.HardwareType;
import inventory.models.IOTThing;

public class MockDB {
	private static MockDB instance = null;
	private Map<UUID, Device> deviceMap;
	private Map<UUID, IOTThing> iotMap;
	
	public static synchronized MockDB getInstance() {
		if (instance == null)
			instance = new MockDB();
		return instance;
	}
	
	private MockDB() {
		deviceMap = new HashMap<UUID, Device>();
		iotMap = new HashMap<UUID, IOTThing>();
		
		// seeding the db
		seedDevices();	
	}
	
	private void seedDevices() {
		List<Device> deviceList1 = Arrays.asList( 
				new Device(HardwareType.ACTUATOR, "Act-01", "SolarEdge"),
				new Device(HardwareType.CONTROLLER, "Cont-01", "Samsung"),
				new Device(HardwareType.SENSOR, "Sens-01", "AMD"));
		
		deviceMap = deviceList1.stream().collect(Collectors.toMap(Device::getUuid, Function.identity()));
		
		IOTThing thing1 = new IOTThing(HardwareType.IOT, "Reporter-01", "SolarEdge");
		thing1.setDevices(deviceList1);
		
		iotMap.put(thing1.getUuid(), thing1);
	}
	
	public Map<UUID, Device> getDeviceMap(){
		return this.deviceMap;
	}
	
	public Map<UUID, IOTThing> getIOTMap(){
		return this.iotMap;
	}
}
