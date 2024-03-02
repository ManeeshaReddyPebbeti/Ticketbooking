package com.manu.conroller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.manu.bonding.PasengerDto;
import com.manu.bonding.Ticket;
import com.manu.servie.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketContoller {
	@Autowired
	private TicketService tser;
	@PostMapping("/booking")
	public ResponseEntity<String> bookingTicket(PasengerDto pdto){
		String bokTicket = tser.bokTicket(pdto);
		return new ResponseEntity<>(bokTicket,HttpStatus.CREATED);
		
	}
	@GetMapping("get/{id}")
	public ResponseEntity<Ticket> getTicketbyids(@PathVariable Long id){
		
		Ticket geti = tser.gettickebyid(id);
		return new ResponseEntity<> (geti,HttpStatus.OK);
		
	}
	@GetMapping("/all")
	public ResponseEntity<List<Ticket>> getAlltickets(@RequestParam(name="length" ,required = false) Long length){
		List<Ticket> allTiket = tser.getAllTiket(length).stream().limit(length).collect(Collectors.toList());
		
		return new ResponseEntity<>(allTiket,HttpStatus.OK);
		
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Ticket>updateTicket(@RequestBody PasengerDto p ,@PathVariable Long id){
		Ticket updateTicket = tser.updateTicket(p, id);
		
		return new ResponseEntity<>(updateTicket,HttpStatus.ACCEPTED);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> cancelTicket(@PathVariable Long id){
		
		String msg="";
		Boolean cancelTicket = tser.cancelTicket(id);
		if(cancelTicket) {
			msg="your ticket is canceld";
		}else {
			msg="your ticket can't be canceld";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
}
