package com.manu.servie;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manu.bonding.PasengerDto;
import com.manu.bonding.Ticket;
import com.manu.repository.TicketReporitoy;
import com.manu.threadhandling.TicketException;
@Service
public class TicketServiceimp implements TicketService {
	
	@Autowired
    private TicketReporitoy tr;
	@Override
	public String bokTicket(PasengerDto pasDto) {
			Ticket t= new Ticket( pasDto.getPasname(), pasDto.getAge(), pasDto.getPasscontactno(), pasDto.getRoutefrom(), pasDto.getRouteto(), pasDto.getGender());
		
			 Ticket ticket = tr.save(t);
			if(ticket!=null) {
				return "Ticket is booked";
			}else 
			return "Ticket is not booked";
	}

	@Override
	public Ticket gettickebyid(Long id) {
		// TODO Auto-generated method stub
 return tr.findById(id).orElseThrow(()->new TicketException("ticket record not found"));
	}

	@Override
	public List<Ticket> getAllTiket(Long lenth) {
		// TODO Auto-generated method stub
		return tr.findAll();
	}

	@Override
	public Ticket updateTicket(PasengerDto pas, Long id) {
		
		Ticket ticket = tr.findById(id).get();
		ticket.setPasname(pas.getPasname());
		ticket.setAge(pas.getAge());
		ticket.setRoutefrom(pas.getRoutefrom());
		ticket.setRouteto(pas.getRouteto());
		ticket.setPasscontactno(pas.getPasscontactno());
		ticket.addTwoHoursToDepartureTime();
		ticket.addTwoHoursToAraivelTime();
		return tr.save(ticket);
	}

	@Override
	public Boolean cancelTicket(Long id) {
		Boolean ststus=false;
		Ticket ticket = tr.findById(id).orElseThrow(()->new TicketException("Ticket not found in my dtabase:  "+id));
		if(ticket!=null) {
		try {
			tr.deleteById(id);
			ststus=true;
		}catch (TicketException e) {
			System.out.println(e);
		}}
		return ststus;	
	}

	@Override
	public Ticket updateTicketByFields(Map<String, Object> fields, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
