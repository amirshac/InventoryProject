package inventory.resources;

import java.util.Map;
import java.util.UUID;

import inventory.DBservice.MockDBService;
import inventory.models.Device;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("devices")
@Produces(MediaType.APPLICATION_JSON)

public class DeviceResource {
	MockDBService dbService = new MockDBService();

	@GET
	public Map<UUID, Device> getAllDevices(){
		return dbService.getAllDevices();
	}
}
