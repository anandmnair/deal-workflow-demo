package com.deal.demo.external.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName="deal", type="deal")
public class LsoDeal {

	@Id
	private Long dealId;
	
	private String dealCode;
	
	private Long amount;
	
	private Long tenure;
}
