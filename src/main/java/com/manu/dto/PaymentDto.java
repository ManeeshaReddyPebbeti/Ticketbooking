package com.manu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
	private Integer paymentid;
	private String pnr;
	private Integer passingerid;
	private Double price;
	private String paymentstatus;

}
