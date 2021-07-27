package com.jpa.repository.sms;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.sms.Failed;

public interface FailedRepository extends JpaRepository<Failed, Long> {
}
