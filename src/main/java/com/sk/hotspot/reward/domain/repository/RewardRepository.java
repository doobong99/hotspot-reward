package com.sk.hotspot.reward.domain.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sk.hotspot.reward.domain.model.Reward;

@RepositoryRestResource
public interface RewardRepository extends PagingAndSortingRepository<Reward, Long>,
                                           QueryDslPredicateExecutor<Reward> {
	
	Reward findByUserId(@Param("userId") String userId);
	
}
