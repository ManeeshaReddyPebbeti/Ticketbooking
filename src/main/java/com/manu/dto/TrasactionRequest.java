package com.manu.dto;

import lombok.Data;


@Data

public class TrasactionRequest {
	
	private PasengerDto passDto;
	private PaymentDto paymentDto;

}
