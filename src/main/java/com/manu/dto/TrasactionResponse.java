package com.manu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrasactionResponse {
	
	private PasengerDto passenger;
	private String pnr;
	private Double price;
	private String message;

}
