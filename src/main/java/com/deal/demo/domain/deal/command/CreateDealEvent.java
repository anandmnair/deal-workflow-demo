package com.deal.demo.domain.deal.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDealEvent {

	private String dealCode;
	
	private Long amount;
	
	private Long tenure;

}
