package com.sk.hotspot.reward.domain.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sk.hotspot.reward.domain.model.RewardHistory;

@RepositoryRestResource
public interface RewardHistoryRepository extends PagingAndSortingRepository<RewardHistory, Long>,
                                           QueryDslPredicateExecutor<RewardHistory> {
	
}
