package com.mail_checker.core.service;

import java.util.List;
import java.util.Optional;

import com.mail_checker.core.entities.MailLog;

public interface MailLogService {

	List<MailLog> findAllMailLogs();
	
	Optional<MailLog> findMailLogById(Long id);
	
	MailLog saveMailLog(MailLog mailLog);
	
	String deleteMailLog(Long id);
	
	String updateMailLog(MailLog mailLog);
	
	String checkMail(String mailAddress);
	
}
