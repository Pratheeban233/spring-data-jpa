package com.jpa.model.sms;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Inbox extends Sms {
	private String message;
}
