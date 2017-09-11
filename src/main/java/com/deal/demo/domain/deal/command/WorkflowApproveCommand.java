package com.deal.demo.domain.deal.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class WorkflowApproveCommand {

	@TargetAggregateIdentifier
	private String dealCode;

	private String approver;
	
	private Boolean status;
}
