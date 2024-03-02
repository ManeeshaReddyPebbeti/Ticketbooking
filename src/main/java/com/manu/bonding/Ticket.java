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
	  private String emailid;
	     private String password;
		@CreationTimestamp
	    @JsonFormat(pattern = "yyyy-MM-dd")
	    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	    private LocalDate journeyDate;
	@CreationTimestamp
	 @JsonFormat(pattern = "HH:mm")
	 @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	    private LocalTime arrivaltime;
	@CreationTimestamp
	
	 @JsonFormat(pattern = "HH:mm:ss")
	
	    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	    private LocalTime departuretime ;
	
	
	public void addTwoHoursToAraivelTime() {
       if (arrivaltime != null) {
       	this.arrivaltime = arrivaltime.plusHours(4);
       }
   }
	public void addTwoHoursToDepartureTime() {
       if (departuretime != null) {
           this.departuretime = departuretime.plusHours(2);
       }
   }
	 
	@UpdateTimestamp
	@Column( insertable = false)
	private LocalDateTime updatedDate;
	   private Integer seats;

	   @Transient
	   private String customIdentifier;
	   public String getCustomIdentifier() {
	        return "ASR" + ticketid;
	   }
	public Ticket( String pasname, Integer age, Long passcontactno, String routefrom, String routeto,
			String gender) {
		super();
		
		this.pasname = pasname;
		this.age = age;
		this.passcontactno = passcontactno;
		this.routefrom = routefrom;
		this.routeto = routeto;
		this.gender = gender;

	}
	 
	
}
