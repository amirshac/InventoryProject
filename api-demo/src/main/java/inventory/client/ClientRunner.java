package inventory.client;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Utils.GsonUtil;
import inventory.DBservice.MockDBService;
import inventory.models.Device;
import inventory.models.HardwareType;
import inventory.models.IOTThing;

public class ClientRunner {
	
	static IOTThing thing1;
	static InventoryReportClient inventoryClient;
	static MockDBService db = new MockDBService();
	
	public static void generateDevices() {
		Device device1 = new Device(HardwareType.ACTUATOR, "Act-02", "SolarEdge");
		device1.setReading(10);
		Device device2 = new Device(HardwareType.CONTROLLER, "Cont-02", "Samsung");
		device2.setReading(10);
		Device device3 = new Device(HardwareType.SENSOR, "Sens-02", "AMD");
		device3.setReading(10);
		
		List<Device> deviceList1 = Arrays.asList(device1, device2, device3);
		
		thing1 = new IOTThing(HardwareType.IOT, "Reporter-02", "SolarEdge");
		thing1.setDevices(deviceList1);
		
//		GsonUtil.saveObjectToJsonFile(device1, "files/device1.json");
//		GsonUtil.saveObjectToJsonFile(device2, "files/device2.json");
//		GsonUtil.saveObjectToJsonFile(device3, "files/device3.json");
//		GsonUtil.saveObjectToJsonFile(thing1, "files/thing1.json");
	}
	
	public static void generateClients() {
		inventoryClient = new InventoryReportClient(thing1);
	}
	
	public static void main(String[] args) {
		generateDevices();
		generateClients();
		
		inventoryClient.run();
		//ExecutorService executorService = Executors.newCachedThreadPool();
		//executorService.execute(inventoryClient);
		
		//Thread.sleep(10000);
		//db.saveToFile();
	}

}
