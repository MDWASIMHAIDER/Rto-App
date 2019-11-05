package com.rto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.entity.RegistrationEntity;
import com.rto.repository.RegistrationRepository;
import com.rto.restrepositort.RestOwnerDetailRepository;
import com.rto.userexception.UserDefineException;


@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository repo;
	
	@Autowired
	private RestOwnerDetailRepository restRepo;
	
	@Override
	public RegistrationEntity saveRegister(RegistrationEntity entity) {
		RegistrationEntity registrationEntity = repo.save(entity);
		return registrationEntity;
	}

	@Override
	public Integer findByRegNum(String num) throws UserDefineException {
		Integer ownerId = restRepo.findByRegistrationNumber(num);
		return ownerId;

	}

	@Override
	public RegistrationEntity getRRegistrationByOwnerId(Integer oid) throws UserDefineException {
		RegistrationEntity registrationDetailByOwnerId =null;
			registrationDetailByOwnerId = restRepo.getRegistrationDetailByOwnerId(oid);
			return registrationDetailByOwnerId;
		}
		
		
	}
	
	


