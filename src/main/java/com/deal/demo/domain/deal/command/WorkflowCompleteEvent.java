package com.deal.demo.domain.deal.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowCompleteEvent {

	private String dealCode;

	private String approver;
	
	private String status;
}
