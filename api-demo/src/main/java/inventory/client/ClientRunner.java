package inventory.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Utils.GsonUtil;
import inventory.DBservice.MockDBService;
import inventory.models.Device;
import inventory.models.HardwareType;
import inventory.models.IotThing;

public class ClientRunner {
	
	static IotThing thing1;
	static InventoryReportClient inventoryClient;
	static MockDBService db = new MockDBService();
	
	public static void generateDevices() {
		Device device1 = new Device("run1".getBytes(),HardwareType.ACTUATOR, "Act-02", "SolarEdge");
		device1.setReading(10);
		Device device2 = new Device("run2".getBytes(),HardwareType.CONTROLLER, "Cont-02", "Samsung");
		device2.setReading(10);
		Device device3 = new Device("run3".getBytes(),HardwareType.SENSOR, "Sens-02", "AMD");
		device3.setReading(10);
		
		List<Device> deviceList1 = new ArrayList<Device>();
		deviceList1.addAll(Arrays.asList(device1, device2, device3));
		
		thing1 = new IotThing("run4".getBytes(),HardwareType.IOT, "Reporter-02", "SolarEdge");
		thing1.setDevices(deviceList1);
		
	}
	
	
	public static void testRemoveDevice() {
		
	}
	
	public static void main(String[] args) {
		generateDevices();
		
		//1 - first submit
		inventoryClient = new InventoryReportClient(thing1);
		inventoryClient.run();
		sleep(5000);
		
		// 2 - re-submit
		inventoryClient.run();
		sleep(5000);
		
		// 3- remove device
		thing1.clearDevices();
		inventoryClient = new InventoryReportClient(thing1);
		inventoryClient.run();
	}

	public static void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
