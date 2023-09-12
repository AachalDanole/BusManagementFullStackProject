package com.BusManagement.BusController;
//import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.BusManagement.Bus.*;
import com.BusManagement.BusServiceImplementation.BusServiceImplementation;


@CrossOrigin(origins = "http://localhost:4200")  
@RestController
@RequestMapping("/api/v1/")

/* The BusController is a controller class that helps to accept the request and returns the responses*/
//handle all the request that start with Redbus.


public class BusController {
	@Autowired	
	public BusServiceImplementation busService;

	public BusController(BusServiceImplementation busService) {
		this.busService = busService;
	}

     
	@PostMapping("bus/saveBus")
	public ResponseEntity <Bus> saveBusDetails(@RequestBody Bus bus){
		try {
		return new ResponseEntity<Bus>(busService.saveBusDetails(bus), HttpStatus.CREATED);
	  }
		catch(Exception exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

     // Update specific bus details rest api
	@PutMapping("bus/updateBus/{busId}")
	public ResponseEntity<Bus> updateBusDetailsById(@PathVariable int busId, @RequestBody Bus busDetails){
		Optional<Bus> busData = busService.getBusDetailsById(busId);
		
		if(busData.isPresent())
		{
			
			busService.updateBusDetailsById(busData, busDetails);
			return new ResponseEntity<>(busService.updateBusDetailsById(busData,busDetails ),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	// Get all bus details  rest api
	@GetMapping("bus/allBus")
	public ResponseEntity<List<Bus>> readAllBusDetails(@RequestParam(required = false) String name) {
		try {
			System.out.println(name);
			List <Bus> busList = busService.getBusDetailsFromDb(name);
			
			if (busList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(busList, HttpStatus.OK);  
		
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	


	
	
	//Get bus details by id rest api
	@GetMapping("bus/readBus/{id}")
	public ResponseEntity<Bus>  getBusDetailsById(@PathVariable("id")  int busId){
		System.out.println(busId); 
		Optional<Bus> bus = busService.getBusDetailsById(busId);
		
		if(bus.isPresent()) {
		return new ResponseEntity<>(bus.get(), HttpStatus.OK);
	        }
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
  
	
	
	// Delete specific bus details  rest api
	@DeleteMapping("bus/deleteBus/{id}")
	public ResponseEntity<String> deleteBusDetailsById(@PathVariable("id")  int busId){
		Optional<Bus> bus = busService.getBusDetailsById(busId);	
		try {
			if(bus.isPresent())
			{
	           	busService.deleteBusDetailsById(busId);
		       return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		    }
			else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
   }
	
	
	// Delete all buses rest api
	@DeleteMapping("bus/deleteAllBuses")
	public ResponseEntity<HttpStatus> toDeleteAllBusDetails(){
		try
		{
			busService.toDeleteAllBusDetails();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception exception) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	

	

	/*
	//Get all bus details rest api
	@GetMapping("/readAllBusByDriverName/{name}")
	public ResponseEntity<List<Bus>> getAllBusesByMatchingTravelsName(@PathVariable("name") String name){
		
		try {
			if(name != null) {
				return new ResponseEntity<>(busService.findByTravelsName(name), HttpStatus.OK);
				}
		    }
		catch(Exception excep) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
		
	}	
	*/

	
	
	    // Get Bus details if AC is not-available  api
		@GetMapping("bus/nonACBus")//nonACBus
		public ResponseEntity<List<Bus>> findByNonAcDomain() {
			try {
				System.out.println("inside contr");
				List<Bus> buses = busService.findByIsAcBus(false);

				if (buses.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(buses, HttpStatus.OK);
			} 
			catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		
		// Get Bus details if AC is available  rest api
				@GetMapping("bus/ACBus")
				public ResponseEntity<List<Bus>> findByAcDomain() {
					try {
						System.out.println("inside ac contr");
						List<Bus> buses = busService.findByIsAcBus(true);

						if (buses.isEmpty()) {
							return new ResponseEntity<>(HttpStatus.NO_CONTENT);
						}
						return new ResponseEntity<>(buses, HttpStatus.OK);
					} 
					catch (Exception e) {
						return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}
				
				@GetMapping("bus/matchRoutes")
				public ResponseEntity<List<Bus>> getBusDetailsBySrcDest(@RequestParam(required = true) String src, @RequestParam(required = true) String dest) {
						
						try {
							
							List<Bus> busList = busService.getBusDetails(src, dest);

							if (busList.isEmpty()) {
								return new ResponseEntity<>(HttpStatus.NO_CONTENT);
							}

							return new ResponseEntity<>(busList, HttpStatus.OK);  

						} catch (Exception e) {
							return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
						}
					}
				
				@GetMapping("bus/filter/Price/{direction}")
				public ResponseEntity<List<Bus>> getAllBuseByPriceHightoLow(@PathVariable("direction") String direction,@RequestParam(required = true) String price){
					try {
						System.out.println("i am here!!!");
						List<Bus> busList = busService.getAllBusByPriceDesc(direction,price);
						System.out.println(direction);
						if (busList.isEmpty()) {
							return new ResponseEntity<>(HttpStatus.NO_CONTENT);
						}

						return new ResponseEntity<>(busList, HttpStatus.OK);  

					} catch (Exception e) {
						return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}
				
				
				@GetMapping("bus/filter/Rating/{direction}")
				public ResponseEntity<List<Bus>> getAllBuseByRatingHightoLow(@PathVariable("direction") String direction,@RequestParam(required = true) String rating){
					try {
						
						List<Bus> busList = busService.getAllBusByRatingsDesc(direction,rating);

						if (busList.isEmpty()) {
							return new ResponseEntity<>(HttpStatus.NO_CONTENT);
						}

						return new ResponseEntity<>(busList, HttpStatus.OK);  

					} catch (Exception e) {
						return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}
				
				
				
				
				
				
				
	}




