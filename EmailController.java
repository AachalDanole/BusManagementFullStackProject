package com.BusManagement.BusController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BusManagement.Bus.Bus;
import com.BusManagement.BusService.EmailService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/em")


public class EmailController {
	@Autowired
	private EmailService emailService;
	@RequestMapping("/")
	public ResponseEntity<String> checkEmail(@RequestParam(required = false) String userEmail, @RequestBody Bus busDetails )  //user email, rest obj(@request Body 
	
	{
		String busName = busDetails.getTravelsName();
		String strMsg = busDetails.getSource()+" "+busDetails.getDestination()+" "+busDetails.getTravelsName()+" "+busDetails.getIsAcBus();
		
	System.out.println(busDetails);	
	emailService.sendEmail(userEmail, "Your Bus booking is confirmed!", "We are happy to inform you that your Booking "+ busName+" "+"is confirmed , You can find your booking information below.\n"+ strMsg +" ");
	return new ResponseEntity<>("Message Send",HttpStatus.CREATED);
	}
}