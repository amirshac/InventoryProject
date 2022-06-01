package inventory.models;

import java.util.UUID;

public class Hardware {
	UUID uuid;
	HardwareType type;
	String model;
	String manufacturer;
	
	public Hardware() {}

	public Hardware(HardwareType type, String model, String manufacturer) {
		generateUUID();
		setType(type);
		setModel(model);
		setManufacturer(manufacturer);
	}
	
	public Hardware(String uuidString, HardwareType type, String model, String manufacturer) {
		setUuid(UUID.fromString(uuidString));
		setType(type);
		setModel(model);
		setManufacturer(manufacturer);
	}
	
	protected synchronized void generateUUID() {
		setUuid(UUID.randomUUID());
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public HardwareType getType() {
		return type;
	}

	public void setType(HardwareType type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Hardware [uuid=" + uuid + ", type=" + type + ", model=" + model + ", manufacturer=" + manufacturer
				+ "]";
	}
	
	
}
