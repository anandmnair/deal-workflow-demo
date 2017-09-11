package com.deal.demo.domain.deal.command;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateWorkflowEvent {

	private String dealCode;
	
	private Long amount;
	
	private Long tenure;
	
	private String status;
	
	private List<String> approvers;

	private String nextApprover;
}
