package ajbc.webservice.rest.api_demo.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import ajbc.webservice.rest.api_demo.beans.DeviceFilterBean;
import ajbc.webservice.rest.api_demo.exceptions.MissingDataException;
import inventory.DBservice.MockDBService;
import inventory.models.Device;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;


@Path("devices")
@Produces(MediaType.APPLICATION_JSON)

public class DeviceResource {
	MockDBService db = new MockDBService();
  
	@GET
	public Response getDevices(@BeanParam DeviceFilterBean deviceFilter){
		
		List<Device> returnList = new ArrayList<Device>();
		
		// empty filters means we return all devices
		if (deviceFilter.getId() == null && deviceFilter.getType() == null && deviceFilter.getManufacturer() == null && deviceFilter.getModel() == null) {
			returnList = db.getAllDevices();
			return Response.ok().entity(returnList).build();
		}
		
		if (deviceFilter.getId() != null){
			Device device = db.getDeviceByUuid(UUID.fromString(deviceFilter.getId()));
			if (device == null) {
				throw new MissingDataException("Device ID not found");
			}else {
				return Response.ok().entity(device).build();
			}
		}	
		
		if (deviceFilter.getType()!=null) {
			returnList = db.getDeviceByType(deviceFilter.getType());
			
			if (returnList.isEmpty()) 
				throw new MissingDataException("No devices found with type " + deviceFilter.getType());
		
			return Response.ok().entity(returnList).build();
		}
		
		if (deviceFilter.getManufacturer()!=null) {
			returnList = db.getDeviceByManufacturer(deviceFilter.getManufacturer());
			
			if (returnList.isEmpty()) 
				throw new MissingDataException("No devices found by manufacturer " + deviceFilter.getManufacturer());
			
			return Response.ok().entity(returnList).build();
		}
		
		if (deviceFilter.getModel()!=null) {
			returnList = db.getDeviceByModel(deviceFilter.getModel());
			
			if (returnList.isEmpty()) 
				throw new MissingDataException("No devices found by model " + deviceFilter.getModel());
			
			return Response.ok().entity(returnList).build();
		}
		
		return Response.ok().entity(returnList).build();
	}
}
