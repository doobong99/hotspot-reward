package com.sk.hotspot.reward.application.sp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.hotspot.reward.domain.model.Reward;
import com.sk.hotspot.reward.domain.model.RewardHistory;
import com.sk.hotspot.reward.domain.service.RewardService;

@RestController
@RequestMapping("/v1/rewards")
public class RewardRestController implements RewardService {
	@Autowired
	private RewardService rewardService;

	@Override
	@GetMapping("/{userId}")
	public Reward findByUserId(@PathVariable(value = "userId", required = true) String userId) {
		System.out.println("findByUserId");
		Reward result = rewardService.findByUserId(userId);
		return result;
	}

	@Override
	@PutMapping
	public Reward update(@RequestBody RewardHistory reward) {
		System.out.println("update");
		Reward result = rewardService.update(reward);
		return result;
	}

	@Override
	@DeleteMapping("/{userId}")
	public void delete(@PathVariable(value = "userId", required = true) String userId) {
		System.out.println("delete");
		rewardService.delete(userId);
	}
}
