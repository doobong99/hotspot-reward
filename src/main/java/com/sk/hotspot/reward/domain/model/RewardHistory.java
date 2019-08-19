package com.sk.hotspot.reward.domain.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sk.hotspot.reward.base.AggregateRoot;

import lombok.Data;

@Data
@Entity
public class RewardHistory implements AggregateRoot {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;

	private String userId;
	@Enumerated(EnumType.STRING)
	private RewardType pointchangetype;
	private Integer rewardpoint;
	private Timestamp createdate = new Timestamp(System.currentTimeMillis());
	
	public RewardHistory(String userId, RewardType pointchangetype, Integer rewardpoint) {
		this.userId = userId;
		this.pointchangetype = pointchangetype;
		this.rewardpoint = rewardpoint;
	}

	public RewardHistory() {
		
	}
}

