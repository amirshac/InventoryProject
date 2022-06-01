package inventory.Runner;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import Utils.GsonUtil;
import inventory.DBservice.MockDBService;
import inventory.models.Device;
import inventory.models.HardwareType;
import inventory.models.IotThing;

public class TestRunner {

	public static void generateDevices() {
		Device device1 = new Device("run1".getBytes(),HardwareType.ACTUATOR, "Act-02", "SolarEdge");
		device1.setReading(10);
		Device device2 = new Device("run2".getBytes(), HardwareType.CONTROLLER, "Cont-02", "Samsung");
		device2.setReading(10);
		Device device3 = new Device("run3".getBytes(), HardwareType.SENSOR, "Sens-02", "AMD");
		device3.setReading(10);
		
		List<Device> deviceList1 = Arrays.asList(device1, device2, device3);
		
		IotThing thing1 = new IotThing("run4".getBytes(), HardwareType.IOT, "Reporter-02", "SolarEdge");
		thing1.setDevices(deviceList1);
		
		GsonUtil.saveObjectToJsonFile(device1, "files/device1.json");
		GsonUtil.saveObjectToJsonFile(device2, "files/device2.json");
		GsonUtil.saveObjectToJsonFile(device3, "files/device3.json");
		GsonUtil.saveObjectToJsonFile(thing1, "files/thing1.json");
	}
	
	public static void main(String[] args) {
		//MockDBService db = new MockDBService();
		//db.saveToFile();
		
		//generateDevices();
	//	IOTThing thing1 = (IOTThing)GsonUtil.loadObjectFromJsonFile("files/thing1.json", IOTThing.class);
	//	System.out.println(thing1);
		
		UUID id1 = UUID.fromString("f7dce26a-013b-4f97-a900-884fc3691d68");
		UUID id2 = UUID.fromString("f7dce26a-013b-4f97-a900-884fc3691d68");
		
	}

}
