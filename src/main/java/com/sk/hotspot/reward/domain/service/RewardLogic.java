package com.sk.hotspot.reward.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.hotspot.reward.domain.model.Reward;
import com.sk.hotspot.reward.domain.model.RewardHistory;
import com.sk.hotspot.reward.domain.model.RewardType;
import com.sk.hotspot.reward.domain.repository.RewardHistoryRepository;
import com.sk.hotspot.reward.domain.repository.RewardRepository;

@Service("rewardLogic")
public class RewardLogic implements RewardService {
	
	@Autowired
	private RewardRepository rewardRepository;
	
	@Autowired
	private RewardHistoryRepository rewardHistoryRepository;
	
	@Override
	public Reward findByUserId(String userId) {
		Reward reward = rewardRepository.findByUserId(userId);
		if(reward == null) {
			reward = new Reward(userId, 0);
			rewardRepository.save(reward);
			
		}
		return reward;
	}

	@Override
	public Reward update(RewardHistory reward) {
		rewardHistoryRepository.save(reward);
		Reward currentReward = rewardRepository.findByUserId(reward.getUserId());
		
		if(currentReward == null){
			currentReward = new Reward(reward.getUserId(), reward.getRewardpoint());
			rewardRepository.save(currentReward);
			
		} else {
			Integer currentPoint = currentReward.getBalance();
			
			switch (reward.getPointchangetype()) {
			case ADD:
				currentReward.setBalance(currentPoint + reward.getRewardpoint());
				break;
			case SUBTRACT:
				currentReward.setBalance(currentPoint - reward.getRewardpoint());
				break;

			default:
				break;
			}
			
			rewardRepository.save(currentReward);
		}
		
		return currentReward;
	}

	@Override
	public void delete(String userId) {
		Reward currentReward = rewardRepository.findByUserId(userId);
		if(currentReward != null) {
			rewardHistoryRepository.save(new RewardHistory(userId, RewardType.SUBTRACT, currentReward.getBalance()));
			currentReward.setBalance(0);
			rewardRepository.save(currentReward);
		}
	}
}
