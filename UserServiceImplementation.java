package com.BusManagement.BusServiceImplementation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BusManagement.Bus.User;
import com.BusManagement.BusRepository.UserRepository;
import com.BusManagement.BusService.UserService;


@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	public void addUser(User obj) {
		
		this.userRepo.save(obj);
	}
	
	public List<User> findBookedUsersByBusId(long busId) {
		
		return this.userRepo.findUsersByBusId(busId);
	}
	
	public Optional<User> getUserDetailsById(int userID) { 
		Optional<User> user = userRepo.findById((long) userID);  
		return user ;
	}
	
	
	public void deleteUserDetailsById(int userID) {

		userRepo.deleteById((long) userID);

	}

	

}
