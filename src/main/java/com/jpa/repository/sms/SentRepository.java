package com.jpa.repository.sms;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.sms.Sent;

public interface SentRepository extends JpaRepository<Sent, Long> {
}
