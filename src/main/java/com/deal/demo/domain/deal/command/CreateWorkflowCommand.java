package com.deal.demo.domain.deal.command;

import java.util.List;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWorkflowCommand {

	@TargetAggregateIdentifier
	private String dealCode;
	
	private Long amount;
	
	private Long tenure;
	
	private List<String> approvers;
}
