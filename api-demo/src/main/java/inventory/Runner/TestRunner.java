package inventory.Runner;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import Utils.GsonUtil;
import inventory.DBservice.MockDBService;
import inventory.models.Device;
import inventory.models.HardwareType;
import inventory.models.IOTThing;

public class TestRunner {

	public static void generateDevices() {
		Device device1 = new Device(HardwareType.ACTUATOR, "Act-02", "SolarEdge");
		device1.setReading(10);
		Device device2 = new Device(HardwareType.CONTROLLER, "Cont-02", "Samsung");
		device2.setReading(10);
		Device device3 = new Device(HardwareType.SENSOR, "Sens-02", "AMD");
		device3.setReading(10);
		
		List<Device> deviceList1 = Arrays.asList(device1, device2, device3);
		
		IOTThing thing1 = new IOTThing(HardwareType.IOT, "Reporter-02", "SolarEdge");
		thing1.setDevices(deviceList1);
		
		GsonUtil.saveObjectToJsonFile(device1, "files/device1.json");
		GsonUtil.saveObjectToJsonFile(device2, "files/device2.json");
		GsonUtil.saveObjectToJsonFile(device3, "files/device3.json");
		GsonUtil.saveObjectToJsonFile(thing1, "files/thing1.json");
	}
	
	public static void main(String[] args) {
		MockDBService db = new MockDBService();
		//db.saveToFile();
		
		generateDevices();
	//	IOTThing thing1 = (IOTThing)GsonUtil.loadObjectFromJsonFile("files/thing1.json", IOTThing.class);
	//	System.out.println(thing1);
	}

}
