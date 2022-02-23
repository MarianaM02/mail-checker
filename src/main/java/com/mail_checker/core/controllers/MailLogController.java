package com.mail_checker.core.controllers;

import java.util.List;
import java.util.Optional;

import com.mail_checker.core.entities.MailLog;

public interface MailLogController {

	String ping();

	List<MailLog> getMailLog();
	
	Optional<MailLog> getMailLogById(Long id);
	
	MailLog addMailLog(MailLog mailLog);
	
	/*
	String deleteMailLog(Long id);
	
	String updateMailLog(MailLog mailLog);
	*/
	
}
