package com.manu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manu.bonding.Ticket;

public interface TicketReporitoy  extends JpaRepository<Ticket, Long>{
	

	

}
