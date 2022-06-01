package inventory.DBservice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Utils.GsonUtil;
import inventory.models.Device;
import inventory.models.IotThing;
import mockDB.MockDB;

public class MockDBService {
	private MockDB db;
	private Map<UUID, Device> deviceMap;
	private Map<UUID, IotThing> iotMap;
	
	public MockDBService() {
		db = MockDB.getInstance();
		deviceMap = db.getDeviceMap();
		iotMap = db.getIOTMap();
	}
	
	public Map<UUID, Device> getAllDevices(){
		return deviceMap;
	}

	public synchronized Device getDeviceByUuid(UUID Uuid) {
		return deviceMap.get(Uuid);
	}
	
	public synchronized Device getDeviceByUuid(String UuidString) {
		return getDeviceByUuid(UUID.fromString(UuidString));
	}
	
	public synchronized Device removeDeviceByUuid(UUID Uuid) {
		return deviceMap.remove(Uuid);
	}
	
	public synchronized Device removeDeviceByUuid(String UuidString) {
		return removeDeviceByUuid(UUID.fromString(UuidString));
	}
	
	public synchronized IotThing getIotByUuid(UUID Uuid) {
		return iotMap.get(Uuid);
	}
	
	public synchronized IotThing getIotByUuid(String UuidString) {
		return getIotByUuid(UUID.fromString(UuidString));
	}
	
	public synchronized IotThing removeIotByUuid(UUID Uuid) {
		return iotMap.remove(Uuid);
	}
	
	public synchronized IotThing removeIotByUuid(String UuidString) {
		return removeIotByUuid(UUID.fromString(UuidString));
	}
	
	/**
	 * Adds device to DB
	 * @param device
	 * @return
	 */
	public synchronized Device addDeviceToDB(Device device) {
		deviceMap.put(device.getUuid(), device);
		return device;
	}
	
	/**
	 * Adds IOT device to DB
	 * @param iot
	 * @return IOTThing
	 */
	public synchronized IotThing addIotToDB(IotThing iot) {
		iotMap.put(iot.getUuid(), iot);		
		return iot;
	}
	
	/**
	 * Saves DB to files, done for testing purposes
	 */
	public synchronized void saveToFile() {
		String fileNameDevices = "files/MockDBDevices.json";
		String fileNameIot = "files/MockDBiot.json";
		
		GsonUtil.saveObjectToJsonFile(deviceMap, fileNameDevices);
		GsonUtil.saveObjectToJsonFile(iotMap, fileNameIot);
		System.out.println("Saved DB to file");
	}

	
}
