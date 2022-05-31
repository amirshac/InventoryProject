package inventory.DBservice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Utils.GsonUtil;
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
	
	public synchronized void saveToFile() {
		String fileNameDevices = "files/MockDBDevices.json";
		String fileNameIot = "files/MockDBiot.json";
		
		GsonUtil.saveObjectToJsonFile(deviceMap, fileNameDevices);
		GsonUtil.saveObjectToJsonFile(iotMap, fileNameIot);
	}
	
}