package com.mail_checker.core.controllersImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail_checker.core.controllers.MailLogController;
import com.mail_checker.core.entities.MailLog;
import com.mail_checker.core.service.MailLogService;

@RestController
public class MailLogControllerImpl implements MailLogController {

	@Autowired
	MailLogService mailLogService;
	
	
	@GetMapping("/ping")
	public String ping() {
		return "PoNg";
	}


	@GetMapping("/logs/all")
	@Override
	public List<MailLog> getMailLog() {
		return mailLogService.findAllMailLogs();
	}


	@GetMapping("/logs/{id}")
	@Override
	public Optional<MailLog> getMailLogById(@PathVariable Long id) {
		return mailLogService.findMailLogById(id);
	}

	
	@GetMapping("/mail/validate/{mailAddress}")
	public String checkMail(@PathVariable String mailAddress) {
		return mailLogService.checkMail(mailAddress);
		
	}

	
	@PostMapping("/logs/add")
	@Override
	public MailLog addMailLog(MailLog mailLog) {
		return mailLogService.saveMailLog(mailLog);
	}

	/*
	@DeleteMapping("/logs/delete/{id}")
	@Override
	public String deleteMailLog(Long id) {
		return mailLogService.deleteMailLog(id);
	}



	@PutMapping("/logs/update")
	@Override
	public String updateMailLog(MailLog mailLog) {
		return mailLogService.updateMailLog(mailLog);
	}
	*/
}
