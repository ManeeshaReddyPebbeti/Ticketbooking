package com.manu.servie;

import java.util.List;
import java.util.Map;

import com.manu.bonding.PasengerDto;
import com.manu.bonding.Ticket;


public interface TicketService {
	
	String bokTicket(PasengerDto pasDto );
	Ticket gettickebyid(Long id);
	List<Ticket> getAllTiket(Long lenth);
	Ticket updateTicket(PasengerDto pas,Long id);
	Boolean cancelTicket(Long id);
	Ticket updateTicketByFields(Map<String, Object>fields,Long id);
	
	

}
