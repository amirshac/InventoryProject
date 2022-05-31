package inventory.DBservice;

import java.util.Map;
import java.util.UUID;

import inventory.models.Device;
import inventory.models.IOTThing;
import mockDB.MockDB;

public class MockDBService {
	private MockDB db;
	private Map<UUID, Device> deviceMap;
	private Map<UUID, IOTThing> iotMap;
	
	public MockDBService() {
		db = MockDB.getInstance();
		deviceMap = db.getDeviceMap();
		iotMap = db.getIOTMap();
	}
	
	public Map<UUID, Device> getAllDevices(){
		return deviceMap;
	}
}
