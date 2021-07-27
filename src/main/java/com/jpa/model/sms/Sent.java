package com.jpa.model.sms;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Entity
@Data
public class Sent extends Sms {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime sentOn;
}
