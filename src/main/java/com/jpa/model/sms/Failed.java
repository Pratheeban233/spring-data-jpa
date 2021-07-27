package com.jpa.model.sms;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Failed extends Sms{
	private String failedMessage;
}
