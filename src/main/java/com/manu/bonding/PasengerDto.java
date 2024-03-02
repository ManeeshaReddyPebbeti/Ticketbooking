package com.manu.bonding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasengerDto {

	 private String pasname;
	 private Integer age;
	 private Long passcontactno;
	 private String routefrom;
	 private String routeto;
	 private String gender;
     private String emailid;
     private String password;
	
}
