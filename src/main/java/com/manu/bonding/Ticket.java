package com.manu.bonding;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long ticketid;

	 private String pasname;
	 private Integer age;
	 private Long passcontactno;
	 private String routefrom;
	 private String routeto;
	 private String gender;
     private Double ticketprice;
     private Integer passid;
   
		@CreationTimestamp
	    @JsonFormat(pattern = "yyyy-MM-dd")
	    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	    private LocalDate journeyDate;
	 
	@UpdateTimestamp
	@Column( insertable = false)
	private LocalDateTime updatedDate;
	   private Integer seats;

 
	
}
