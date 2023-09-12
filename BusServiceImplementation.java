package com.BusManagement.BusServiceImplementation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.BusManagement.Bus.Bus;
import com.BusManagement.BusRepository.BusRepository;
import com.BusManagement.BusService.BusService;


/*In this class, we implement all the methods to bus */


    @Service
	public class BusServiceImplementation implements BusService{
    	
    	@Autowired	
		private BusRepository busRepository;

		public BusServiceImplementation(BusRepository busRepository) {
			this.busRepository = busRepository;
		}
         // insert bus details to database
		@Override
		public Bus saveBusDetails(Bus bus) {
			return busRepository.save(bus);  
		}

		 // get all bus details from database
		@Override
		public List<Bus> getBusDetailsFromDb(String name ) {
			List<Bus> bus = new ArrayList<Bus>();
			
			if (name == null) 
				busRepository.findAll().forEach(bus :: add);
			else
				 busRepository.findBusByTravelsNameContainingIgnoreCase(name).forEach(bus::add);
			
			return bus;
				
		}
		
	        // get bus details by id from database
		@Override
		public Optional  <Bus> getBusDetailsById(int busId) { 
			Optional<Bus> bus = busRepository.findById(busId);  
			return bus;
		}
	
		// get bus details from database
		public Bus getByDestination(int busId) {
			Optional<Bus> bus = busRepository.findById(busId);
			if(bus.isPresent()) {
				Bus busObj=bus.get();
				System.out.println(busObj);
				return bus.get();
			}
			else {
				return null;
			}
		}
		
		// update bus details to database
		public Bus updateBusDetailsById( Optional<Bus> busDet,Bus busDetails) {

			Bus bus = busDet.get();
			bus.setDriverName(busDetails.getDriverName());
			bus.setDestination(busDetails.getDestination());
			bus.setCost(busDetails.getCost());
			bus.setTotalSeat(busDetails.getTotalSeat());
			bus.setIsAcBus(busDetails.getIsAcBus());
			bus.setRating(busDetails.getRating());
			return busRepository.save(bus);
		}
		
		
	
         // delete buses by id from database
		@Override
		public void deleteBusDetailsById(int busId) {
			
			busRepository.deleteById(busId);
			}

		
		   // delete all buses from database
		public void toDeleteAllBusDetails() {
			busRepository.deleteAll();
			
		     }


		// To get bus details having AC to database
		public List<Bus>findByIsAcBus(boolean isAcBus)
		{
			List<Bus> busList = new ArrayList<Bus>();
			busRepository.findByIsAcBus(isAcBus).forEach(busList :: add);
			return busList;


		}
		
		// To get bus details from db by travels name
		public List<Bus> findByTravelsName(String travelsName) {
			List<Bus> busList = new ArrayList<Bus>();
			busRepository.findBusByTravelsNameContainingIgnoreCase(travelsName).forEach(busList::add);
			return busList;


		}
		
		public List<Bus> getBusDetails(String src, String dest) {
			
			List<Bus> bus = new ArrayList<Bus>();

			
				busRepository.findBySourceAndDestination(src,dest).forEach(bus::add);

			return bus;
		}
		
		
		
          public List<Bus> getAllBusByPriceDesc(String direction,String price) {
			
			List<Bus> bus = busRepository.findAll(Sort.by(getSortDirection(direction),price));
			return bus;
		}
          
          public List<Bus> getAllBusByRatingsDesc(String direction,String rating) {
        		
  			List<Bus> bus = busRepository.findAll(Sort.by(getSortDirection(direction),rating));
  			return bus;
  		}
          
          
  		
  		private Sort.Direction getSortDirection(String direction){
  			if(direction.equals("asc")){
  				System.out.println("came here");
  				return Sort.Direction.ASC;
  			}
  			else if(direction.equals("desc")) {
  				System.out.println("came here desc");
  				return Sort.Direction.DESC;
  			}
  			return Sort.Direction.ASC;
  					
  		}
          
          
          
	}
    
    
    
    

	
	

