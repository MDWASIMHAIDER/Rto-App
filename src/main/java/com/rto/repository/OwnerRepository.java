package com.rto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rto.entity.OwnerEntity;
import com.sun.xml.bind.v2.model.core.ID;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Serializable> {
	
}
