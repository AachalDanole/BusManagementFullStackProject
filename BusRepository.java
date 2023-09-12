package com.BusManagement.BusRepository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.BusManagement.Bus.*;


/*The busRepository interface is a spring Data JPA repository that provides 
	database access and CRUD operations for the bus entity.
*/

@Repository

public interface BusRepository extends JpaRepository<Bus, Integer> {

	List<Bus> findByIsAcBus(boolean status);
	List <Bus> findBusByTravelsNameContainingIgnoreCase(String name);
	List<Bus>findBySourceAndDestination(String src,String dest);
	
}
