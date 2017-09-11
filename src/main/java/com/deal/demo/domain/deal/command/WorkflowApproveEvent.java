package com.deal.demo.domain.deal.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowApproveEvent {

	private String dealCode;

	private String status;
	
	private String approver;
	
	private String nextAprover;
}
