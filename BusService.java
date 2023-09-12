package com.BusManagement.BusService;
import java.util.List;
import com.BusManagement.Bus.Bus;
import java.util.Optional;


/* BusService is interface in which methods are declared */
public interface BusService {

	
	// Method to save a new Bus entity to the database
	Bus saveBusDetails(Bus bus);
	
	 // Method to retrieve all Bus entities from the database
	List<Bus> getBusDetailsFromDb(String busData);
	
	// Method to retrieve a specific Bus entity by its ID
	Optional<Bus> getBusDetailsById(int busId);
	
	// Method to update an existing Bus entity in the database based on its ID
	Bus updateBusDetailsById( Optional<Bus> busDet,Bus busDetails);
	
	// Method to delete a specific Bus entity from the database based on its ID
	void deleteBusDetailsById(int busId);
	
	 // Method to delete all Bus entities from the database
	void toDeleteAllBusDetails();

}




