package com.deal.demo.external.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.deal.demo.external.model.LsoDeal;

@Repository
public interface LsoDealRepository extends ElasticsearchRepository<LsoDeal, Long> {

}
