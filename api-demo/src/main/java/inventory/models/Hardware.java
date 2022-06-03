package inventory.models;

import java.util.Objects;
import java.util.UUID;

public class Hardware{
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
	
	public Hardware(byte[] uuidBytes, HardwareType type, String model, String manufacturer) {
		setUuid(uuidBytes);
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
	
	public void setUuid(String str) {
		this.uuid = UUID.fromString(str);
	}
	
	public void setUuid(byte[] bytes) {
		this.uuid = UUID.nameUUIDFromBytes(bytes);
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

	@Override
	public int hashCode() {
		return Objects.hash(manufacturer, model, type, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hardware other = (Hardware) obj;
		return Objects.equals(manufacturer, other.manufacturer) && Objects.equals(model, other.model)
				&& type == other.type && Objects.equals(uuid, other.uuid);
	}
	
	
}
