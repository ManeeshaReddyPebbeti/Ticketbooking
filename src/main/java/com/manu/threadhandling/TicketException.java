package com.manu.threadhandling;

public class TicketException extends RuntimeException {
	   public TicketException() {
			
		}
		public TicketException(String msg) {
			super(msg);
		}
}
