package com.manu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasengerDto {
     private Long ticketid;
	 private String pasname;
	 private Integer age;
	 private Long passcontactno;
	 private String routefrom;
	 private String routeto;
	 private String gender;
     private Integer seats;
     private Double ticketprice;
     private Integer passid;
  
 
	
}
