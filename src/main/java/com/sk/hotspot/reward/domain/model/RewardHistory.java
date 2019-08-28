package com.sk.hotspot.reward.domain.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sk.hotspot.reward.base.AggregateRoot;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
public class RewardHistory implements AggregateRoot {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(required = false, hidden = true)
	protected Long id;

	@ApiModelProperty(required = true, position = 1)
	private String userId;
	@ApiModelProperty(required = true, position = 2)
	@Enumerated(EnumType.STRING)
	private RewardType pointchangetype;
	@ApiModelProperty(required = true, position = 3)
	private Integer rewardpoint;
	
	@ApiModelProperty(required = false, hidden = true)
	private Timestamp createdate = new Timestamp(System.currentTimeMillis());
	
	public RewardHistory(String userId, RewardType pointchangetype, Integer rewardpoint) {
		this.userId = userId;
		this.pointchangetype = pointchangetype;
		this.rewardpoint = rewardpoint;
	}

	public RewardHistory() {
		
	}
}

