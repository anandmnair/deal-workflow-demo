package com.deal.demo.domain.deal.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDealCommand {

	@TargetAggregateIdentifier
	private String dealCode;
	
	private Long amount;
	
	private Long tenure;
}
