package com.rto.service;

import com.rto.entity.AddressEntity;

public interface AddressService {
	public AddressEntity saveAddress(AddressEntity entity);
	public AddressEntity getAddressById(Integer id);
	public AddressEntity getAddressByOwnerId(Integer oid);
}
