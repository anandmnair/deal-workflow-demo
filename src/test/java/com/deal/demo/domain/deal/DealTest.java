package com.deal.demo.domain.deal;

import java.util.Arrays;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

import com.deal.demo.domain.deal.command.CreateDealCommand;
import com.deal.demo.domain.deal.command.CreateDealEvent;
import com.deal.demo.domain.deal.command.CreateWorkflowCommand;
import com.deal.demo.domain.deal.command.CreateWorkflowEvent;


public class DealTest {

private FixtureConfiguration<Deal> fixture;
	
	@Before
	public void setUp(){
		fixture=new AggregateTestFixture<>(Deal.class);
	}
	
	@Test
	public void testCreateDeal(){
		fixture.givenNoPriorActivity()
			.when(new CreateDealCommand("DL1001", 1000L, 10L))
			.expectEvents(new CreateDealEvent("DL1001", 1000L, 10L))
			;
	}
	
	@Test
	public void testCreateWorkflow(){
		String[] approvers = {"A", "B","C"};
		fixture.given(new CreateDealEvent("DL1001", 1000L, 10L))
			.when(new CreateWorkflowCommand("DL1001", 1000L, 10L, Arrays.asList(approvers)))
			.expectEvents(new CreateWorkflowEvent("DL1001", 1000L, 10L,"IN_PROGRESS", Arrays.asList(approvers), approvers[0]))
			;
	}
	
	
	
}
