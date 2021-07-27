package com.jpa.repository.sms;

import com.jpa.model.sms.Inbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InboxRepository extends JpaRepository<Inbox,Long>{
}
