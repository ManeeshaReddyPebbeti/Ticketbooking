package com.manu.servie;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.manu.bonding.Ticket;
import com.manu.dto.PasengerDto;
import com.manu.dto.PaymentDto;
import com.manu.dto.TrasactionRequest;
import com.manu.dto.TrasactionResponse;
import com.manu.repository.TicketReporitoy;
import com.manu.threadhandling.TicketException;
@Service
public class TicketServiceimp implements TicketService {
	
	@Autowired
    private TicketReporitoy tr;

	@Override
	public TrasactionResponse bokTicket(TrasactionRequest request) {
		String response="";
		PasengerDto pasengerDto = request.getPassDto();
		 PaymentDto paymentDto = request.getPaymentDto();
		 pasengerDto.setTicketid(pasengerDto.getTicketid());
		 paymentDto.setPrice(pasengerDto.getTicketprice());
		 paymentDto.setPassingerid(pasengerDto.getPassid());
		PaymentDto paymentresponse = WebClient.create("http://localhost:8082").post()
		.uri("payment/pay")
		.bodyValue(paymentDto)
		.retrieve()
		.bodyToMono(PaymentDto.class)
		.block();
		response=paymentresponse.getPaymentstatus().equals("success")?"payment success ":"there is failure in payment try again";
		Ticket t= new Ticket();
		BeanUtils.copyProperties(pasengerDto, t);
		tr.save(t);
		return TrasactionResponse.builder().passenger(pasengerDto)
				.pnr(paymentDto.getPnr())
				.price(paymentDto.getPrice())
				.message(response)
				.build();
		         
	}

	@Override
	public Ticket gettickebyid(Long id) {
		
		return tr.findById(id).orElseThrow(()->new TicketException("your ticket not found in database"));
	}

	@Override
	public List<Ticket> getAllTiket(Long lenth) {
	          
		return  tr.findAll().stream().limit(lenth).collect(Collectors.toList());
	}



}
