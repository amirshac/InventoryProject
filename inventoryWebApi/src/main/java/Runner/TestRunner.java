package Runner;

import inventory.models.Hardware;
import inventory.models.HardwareType;

//running basic tests
public class TestRunner {

	public static void main(String[] args) {
		Hardware hardware = new Hardware(HardwareType.ACTUATOR, "Act-01", "SolarEdge");
		System.out.println(hardware);
	}

}
