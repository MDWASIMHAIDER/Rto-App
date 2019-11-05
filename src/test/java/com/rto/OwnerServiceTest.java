package com.rto;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.rto.entity.OwnerEntity;
import com.rto.repository.OwnerRepository;
import com.rto.service.OwnerService;
import com.rto.service.OwnerServiceImpl;
import com.rto.userexception.UserDefineException;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class OwnerServiceTest {
	
	//target
	@InjectMocks
	private OwnerServiceImpl ownerService;
	
	//dependent
	@Mock
	private OwnerRepository ownerRepository;
	
	@Test
	public void saveOwnerPositive() throws UserDefineException{
		OwnerEntity entity=new OwnerEntity();
		entity.setVechile_Owner_Id(1000);
		entity.setDob(new Date(1998, 3, 12));
		entity.setEmail("wasimgmail.com");
		entity.setFirstName("md");
		entity.setLastName("wasim");
		entity.setGender("male");
		entity.setPhone(947344268l);
		entity.setCreate_Date(new Date());
		entity.setUpdate_Date(new Date());
		
		
		
		OwnerEntity expected=new OwnerEntity();
		expected.setVechile_Owner_Id(1000);
		expected.setDob(new Date(1998, 3, 12));
		expected.setEmail("wasimgmail.com");
		expected.setFirstName("md");
		expected.setLastName("wasim");
		expected.setGender("male");
		expected.setPhone(947344268l);
		expected.setCreate_Date(new Date());
		expected.setUpdate_Date(new Date());
		
		
		when(ownerRepository.save(entity)).thenReturn(expected);
		OwnerEntity actual=ownerService.saveOwner(entity);
		assertEquals(expected,actual);
		
	}
	
	@Test
	public void saveOwnerNegative() throws UserDefineException{
		OwnerEntity entity=null;
		when(entity==null).thenThrow(new UserDefineException("unkown exp"));
	}
}
