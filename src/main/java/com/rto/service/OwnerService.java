package com.rto.service;

import com.rto.entity.OwnerEntity;
import com.rto.userexception.UserDefineException;

public interface OwnerService {
	public OwnerEntity saveOwner(OwnerEntity entity) throws UserDefineException;
	public OwnerEntity getById(Integer oid);
}
