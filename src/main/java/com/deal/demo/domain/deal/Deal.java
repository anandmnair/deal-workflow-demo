package com.deal.demo.domain.deal;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import java.util.List;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.deal.demo.domain.deal.command.CreateDealCommand;
import com.deal.demo.domain.deal.command.CreateDealEvent;
import com.deal.demo.domain.deal.command.CreateWorkflowCommand;
import com.deal.demo.domain.deal.command.CreateWorkflowEvent;
import com.deal.demo.domain.deal.command.WorkflowApproveCommand;
import com.deal.demo.domain.deal.command.WorkflowApproveEvent;
import com.deal.demo.domain.deal.command.WorkflowCompleteEvent;

import lombok.Data;
import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
@Data
public class Deal {

	@AggregateIdentifier
	private String dealCode;
	
	private Long amount;
	
	private Long tenure;
	
	private String status;
	
	private List<String> approvers;
	
	private String currentApprover;

	private String nextApprover;

	@CommandHandler
	public Deal(CreateDealCommand command) {
		apply(new CreateDealEvent(command.getDealCode(), command.getAmount(), command.getTenure()));
	}
	
    @CommandHandler
    public void handle(CreateWorkflowCommand command) {
        apply(new CreateWorkflowEvent(dealCode,  command.getAmount(), command.getTenure(), "IN_PROGRESS", command.getApprovers(),command.getApprovers().get(0)));
    }
    
    @CommandHandler
    public void handle(WorkflowApproveCommand command) {
    	if(!command.getStatus() || command.getApprover().equals(approvers.get(approvers.size()-1))) {
    		apply(new WorkflowCompleteEvent(dealCode,  command.getApprover(), command.getStatus()?"APPROVED":"REJECTED"));
    	}
    	else {
    		 int index = this.approvers.indexOf(command.getApprover());
    		 apply(new WorkflowApproveEvent(dealCode,  "IN_PROGRESS", command.getApprover(),  this.approvers.get(index+1)));
    	}
    }
    
	@EventSourcingHandler
	public void on(CreateDealEvent event) {
		this.dealCode=event.getDealCode();
		this.amount=event.getAmount();
		this.tenure=event.getTenure();
		this.status="TODO";
	}
	
	@EventSourcingHandler
	public void on(CreateWorkflowEvent event) {
		this.dealCode=event.getDealCode();
		this.amount=event.getAmount();
		this.tenure=event.getTenure();
		this.status=event.getStatus();
		this.approvers=event.getApprovers();
		this.nextApprover=event.getNextApprover();
	}
	
	@EventSourcingHandler
	public void on(WorkflowApproveEvent event) {
		this.status=event.getStatus();
		this.currentApprover=event.getApprover();
		this.nextApprover=event.getNextAprover();
	}

}
