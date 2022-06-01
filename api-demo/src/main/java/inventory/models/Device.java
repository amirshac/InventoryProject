package inventory.models;

import java.util.Random;

public class Device extends Hardware{
	private final static double MIN_READING = 0;
	private final static double MAX_READING = 100;
	
	protected double reading;
	
	public Device() {}
	
	public Device(HardwareType type, String model, String manufacturer) {
		super(type,model,manufacturer);
	}

	public Device(HardwareType type, String model, String manufacturer, double reading) {
		super(type,model,manufacturer);
		setReading(reading);
	}
	
	public Device(String uuidString, HardwareType type, String model, String manufacturer) {
		super(uuidString, type ,model,manufacturer);
	}
	
	public Device(byte[] uuidBytes, HardwareType type, String model, String manufacturer) {
		super(uuidBytes, type ,model,manufacturer);
	}
	
	public Device(String uuidString, HardwareType type, String model, String manufacturer, double reading) {
		super(uuidString, type ,model,manufacturer);
		setReading(reading);
	}
	
	public double getReading() {
		return reading;
	}

	public void setReading(double reading) {
		this.reading = reading;
	}
	
	public void simulateReading() {
		Random random = new Random();
		setReading(random.nextDouble(MIN_READING,MAX_READING));
	}
}
