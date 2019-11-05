package com.rto.restrepositort;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rto.entity.RegistrationEntity;

@Repository
public interface RestOwnerDetailRepository extends JpaRepository<RegistrationEntity, Integer>{
	
	@Query("select e.detail.vechile_Owner_Id from RegistrationEntity e where e.vechile_Reg_Num=:uid")
	public Integer findByRegistrationNumber(String uid);
	
	@Query("from RegistrationEntity e where e.detail.vechile_Owner_Id=:oid")
	public RegistrationEntity getRegistrationDetailByOwnerId(Integer oid);
}
//select vechile_Reg_Id,reg_Date,create_Date,update_Date,vechile_Reg_Num,reg_center