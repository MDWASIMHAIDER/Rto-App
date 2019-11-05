package com.rto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.entity.VechileEntity;
import com.rto.repository.VechileRepository;


@Service
public class VechileServiceImpl implements VechileService {
	
	@Autowired
	private VechileRepository repo;
	
	@Override
	public VechileEntity saveVechile(VechileEntity entity) {
		VechileEntity vechileEntity = repo.save(entity);
		return vechileEntity;
	}

	@Override
	public VechileEntity getVechileById(Integer id) {
		Optional<VechileEntity> optional = repo.findById(id);
		VechileEntity vechileEntity = optional.get();
		return vechileEntity;
	}

	@Override
	public VechileEntity getVechileByOwnerId(Integer oid) {
		VechileEntity vechileEntity = repo.getVechileById(oid);
		return vechileEntity;
	}

}
