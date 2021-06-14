package com.har.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankAccount {

	private Integer accountId;
	private String accountType;
	private Long accountNumber;
   private Double balance;
	
}
