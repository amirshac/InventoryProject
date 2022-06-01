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
import inventory.models.IotThing;

public class MockDB {
	private static MockDB instance = null;
	private Map<UUID, Device> deviceMap;
	private Map<UUID, IotThing> iotMap;
	
	public static synchronized MockDB getInstance() {
		if (instance == null)
			instance = new MockDB();
		return instance;
	}
	
	private MockDB() {
		deviceMap = new HashMap<UUID, Device>();
		iotMap = new HashMap<UUID, IotThing>();
		
		// seeding the db
		seedDevices();	
	}
	
	private void seedDevices() {
		List<Device> deviceList1 = Arrays.asList( 
				new Device("db1".getBytes(), HardwareType.ACTUATOR, "Act-01", "SolarEdge"),
				new Device("db2".getBytes(), HardwareType.CONTROLLER, "Cont-01", "Samsung"),
				new Device("db3".getBytes(), HardwareType.SENSOR, "Sens-01", "AMD"));
		
		deviceMap = deviceList1.stream().collect(Collectors.toMap(Device::getUuid, Function.identity()));
		
		IotThing thing1 = new IotThing("db4".getBytes(), HardwareType.IOT, "Reporter-01", "SolarEdge");
		thing1.setDevices(deviceList1);
		
		iotMap.put(thing1.getUuid(), thing1);
	}
	
	public Map<UUID, Device> getDeviceMap(){
		return this.deviceMap;
	}
	
	public Map<UUID, IotThing> getIOTMap(){
		return this.iotMap;
	}
}
