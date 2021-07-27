package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.model.sms.Failed;
import com.jpa.model.sms.Inbox;
import com.jpa.model.sms.Sent;
import com.jpa.model.sms.Sms;
import com.jpa.repository.sms.FailedRepository;
import com.jpa.repository.sms.InboxRepository;
import com.jpa.repository.sms.SentRepository;
import com.jpa.repository.sms.SmsRepository;

@RestController
public class SmsController {

	@Autowired
	private SmsRepository smsRepository;

	@Autowired
	private InboxRepository inboxRepository;

	@Autowired
	private SentRepository sentRepository;

	@Autowired
	private FailedRepository failedRepository;

	@PostMapping("/addsms")
	public ResponseEntity<Object> addSms(@RequestBody Sms sms) {
		return ResponseEntity.ok(smsRepository.save(sms));
	}

	@PostMapping("/addinbox")
	public ResponseEntity<Object> addInbox(@RequestBody Inbox inbox) {
		return ResponseEntity.ok(inboxRepository.save(inbox));
	}

	@PostMapping("/addsent")
	public ResponseEntity<Object> addSend(@RequestBody Sent sent) {
		return ResponseEntity.ok(sentRepository.save(sent));
	}

	@PostMapping("/addfail")
	public ResponseEntity<Object> addFailed(@RequestBody Failed failed) {
		return ResponseEntity.ok(failedRepository.save(failed));
	}

	@GetMapping("getsms")
	public ResponseEntity<Object> getSms() {
		return ResponseEntity.ok(smsRepository.findAll());
	}

	@GetMapping("/getinbox")
	public ResponseEntity<Object> getInbox() {
		return ResponseEntity.ok(inboxRepository.findAll());
	}
}
