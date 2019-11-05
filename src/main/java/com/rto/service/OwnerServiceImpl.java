package com.rto.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.entity.OwnerEntity;
import com.rto.repository.OwnerRepository;
import com.rto.userexception.UserDefineException;

@Service
public class OwnerServiceImpl implements OwnerService {
	Logger logg=(Logger) LoggerFactory.getLogger(OwnerServiceImpl.class);
	
	@Autowired
	private OwnerRepository repo;
	
	@Override
	public OwnerEntity saveOwner(OwnerEntity entity) throws UserDefineException {
		if(entity==null) {
			logg.info("Entity is null","Entity is null");
			logg.trace("test for trace");
			throw new UserDefineException("Null pointerExcetion");
		}
		OwnerEntity ownerEntity = repo.save(entity);
		//ownerEntity.getVechile_Owner_Id();
		return ownerEntity;
	}

	@Override
	public OwnerEntity getById(Integer oid) {
		Optional<OwnerEntity> optional = repo.findById(oid);
		OwnerEntity ownerEntity = optional.get();
		return ownerEntity;
	}

}
