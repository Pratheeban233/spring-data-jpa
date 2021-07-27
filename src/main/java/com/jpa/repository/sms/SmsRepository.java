package com.jpa.repository.sms;

import com.jpa.model.sms.Sms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsRepository extends JpaRepository<Sms,Long> {
}
