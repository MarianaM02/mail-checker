package com.mail_checker.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mail_checker.core.entities.MailLog;

@Repository
public interface MailLogRepository extends JpaRepository<MailLog, Long>{
	
	void save(Optional<MailLog> mailLogToUpdate);

}
