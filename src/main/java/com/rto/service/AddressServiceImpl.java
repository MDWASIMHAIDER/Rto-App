package com.rto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.entity.AddressEntity;
import com.rto.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository repo;
	@Override
	public AddressEntity saveAddress(AddressEntity entity) {
		AddressEntity addressEntity = repo.save(entity);
		return addressEntity;
	}
	@Override
	public AddressEntity getAddressById(Integer id) {
		Optional<AddressEntity> optional = repo.findById(id);
		AddressEntity addressEntity = optional.get();
		return addressEntity;
	}
	@Override
	public AddressEntity getAddressByOwnerId(Integer oid) {
		AddressEntity addressByOwnerId = repo.getAddressByOwnerId(oid);
		return addressByOwnerId;
	}

}
