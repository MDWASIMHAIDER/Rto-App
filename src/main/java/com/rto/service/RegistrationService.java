package com.rto.service;

import java.util.List;

import com.rto.entity.RegistrationEntity;
import com.rto.userexception.UserDefineException;

public interface RegistrationService {
	public RegistrationEntity saveRegister(RegistrationEntity entity);
	public Integer findByRegNum(String num) throws UserDefineException;
	public RegistrationEntity getRRegistrationByOwnerId(Integer oid) throws UserDefineException;
}
