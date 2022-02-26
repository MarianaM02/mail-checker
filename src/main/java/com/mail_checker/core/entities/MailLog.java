package com.mail_checker.core.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter @EqualsAndHashCode
public class MailLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Basic
	String valueMail;
	Boolean validated;
	@Temporal(TemporalType.TIMESTAMP)
	Date date;

}
