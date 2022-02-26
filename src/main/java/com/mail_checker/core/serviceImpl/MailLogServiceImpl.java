package com.mail_checker.core.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mail_checker.core.entities.MailLog;
import com.mail_checker.core.repository.MailLogRepository;
import com.mail_checker.core.service.MailLogService;

@Service
public class MailLogServiceImpl implements MailLogService {

	@Autowired
	private MailLogRepository mailLogRepo;

	@Override
	public List<MailLog> findAllMailLogs() {
		return mailLogRepo.findAll();
	}

	@Override
	public Optional<MailLog> findMailLogById(Long id) {
		Optional<MailLog> mailLog = mailLogRepo.findById(id);
		return mailLog;
	}

	@Override
	public MailLog saveMailLog(MailLog mailLog) {
		if (mailLog != null) {
			return mailLogRepo.save(mailLog);
		}
		return new MailLog();
	}

	@Override
	public String deleteMailLog(Long id) {
		if (mailLogRepo.findById(id).isPresent()) {
			mailLogRepo.deleteById(id);
			return "Log Eliminado correctamente.";
		}

		return "Log no existe";
	}

	@Override
	public String updateMailLog(MailLog mailLogUpdated) {
		Long num = mailLogUpdated.getId();

		if (mailLogRepo.findById(num).isPresent()) {
			MailLog mailLogToUpdate = new MailLog();
			mailLogToUpdate.setId(mailLogUpdated.getId());
			mailLogToUpdate.setValueMail(mailLogUpdated.getValueMail());
			mailLogToUpdate.setValidated(mailLogUpdated.getValidated());
			mailLogToUpdate.setDate(mailLogUpdated.getDate());
			mailLogRepo.save(mailLogToUpdate);
			return "Log modificado correctamente.";
		}

		return "Error al modificar el log";
	}

	@Override
	public String checkMail(String mailAddress) {
		boolean esValido = validacionPorRegex(mailAddress) && validacionPorDominio(mailAddress);

		// Creacion del registro
		MailLog mailLog = new MailLog();
		mailLog.setValueMail(mailAddress);
		mailLog.setValidated(esValido);
		mailLog.setDate(new Date());
		saveMailLog(mailLog);

		return esValido ? "Es un mail válido" : "No es un mail valido";
	}
	
	private boolean validacionPorDominio(String str) {
		boolean tieneDominioValido = false;
		String mailDividido[] = null;
		String dominioDividido[] = null;
		if (str.contains("@")){
			mailDividido = str.split("@");
			dominioDividido = mailDividido[1].split("\\.");
			tieneDominioValido = mailDividido.length == 2 && dominioDividido.length >= 2;
		}
		return tieneDominioValido;
	}
	
	private boolean validacionPorRegex(String str) {
		// Regular Expression by RFC 5322 for Email Validation
		String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		boolean esRFC5322Valido = Pattern.compile(regexPattern).matcher(str).matches();
		return esRFC5322Valido;
	}

}
