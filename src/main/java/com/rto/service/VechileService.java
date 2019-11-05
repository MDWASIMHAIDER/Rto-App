package com.rto.service;

import com.rto.entity.VechileEntity;

public interface VechileService {
	public VechileEntity saveVechile(VechileEntity entity);
	public VechileEntity getVechileById(Integer id);
	public VechileEntity getVechileByOwnerId(Integer oid);
}
