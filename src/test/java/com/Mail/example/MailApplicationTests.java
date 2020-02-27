package com.Mail.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.Mail.example.Filter.Filter1;
import com.Mail.example.Service.UserServiceImpl;
@SpringJUnitConfig(Filter1.class)

@SpringBootTest
class MailApplicationTests {
	


	@Autowired
		private UserServiceImpl usi;
		
		@Test
		 public void scheduler() throws InterruptedException 
	 {
			Thread.sleep(200);
		
			    }
	}


