package com.sk.hotspot.reward.domain.service;

import com.sk.hotspot.reward.domain.model.Reward;
import com.sk.hotspot.reward.domain.model.RewardHistory;

public interface RewardService {
	Reward findByUserId(String userId);
	
	Reward update(RewardHistory reward);

	void delete(String userId);
}
