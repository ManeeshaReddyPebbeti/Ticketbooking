package com.manu.servie;

import java.util.List;
import java.util.Map;

import com.manu.bonding.Ticket;
import com.manu.dto.PasengerDto;
import com.manu.dto.TrasactionRequest;
import com.manu.dto.TrasactionResponse;


public interface TicketService {
	
	TrasactionResponse bokTicket(TrasactionRequest pasDto );
	Ticket gettickebyid(Long id);
	List<Ticket> getAllTiket(Long lenth);
//	Ticket updateTicket(PasengerDto pas,Long id);
//	Boolean cancelTicket(Long id);
//	Ticket updateTicketByFields(Map<String, Object>fields,Long id);
	
	

}
