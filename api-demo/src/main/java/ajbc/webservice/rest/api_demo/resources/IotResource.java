package ajbc.webservice.rest.api_demo.resources;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import inventory.DBservice.MockDBService;
import inventory.models.Device;
import inventory.models.IotThing;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;


@Path("iots")
@Produces(MediaType.APPLICATION_JSON)

public class IotResource {
	MockDBService db = new MockDBService();
	
//	@GET
//	public List<IotThing> getAllIots(){
//		return db.getAllIots().values().stream().collect(Collectors.toList());
//	}	
}
