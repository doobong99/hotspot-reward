package com.sk.hotspot.reward.domain.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.sk.hotspot.reward.base.AggregateRoot;

import lombok.Data;

@Data
@Entity
public class Reward implements AggregateRoot {
	@Id
	private String userId;
	private Integer balance;
	private Timestamp modifyDate = new Timestamp(System.currentTimeMillis());
	
	public Reward(String userId, Integer balance) {
		this.userId = userId;
		this.balance = balance;
	}
	public Reward() {
	}
}

