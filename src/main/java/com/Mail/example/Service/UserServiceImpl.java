package com.Mail.example.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Mail.example.Controller.RegistrationController;
import com.Mail.example.Dto.UserDto;
import com.Mail.example.Entity.User;
import com.Mail.example.Repository.UserRepository;

@Service
@Component
public class UserServiceImpl implements UserServices {

	@Autowired
	UserRepository ur;
	private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	public List<UserDto> findall() {
		List<UserDto> user = new ArrayList<UserDto>();
		try {
			List<User> usersList = null;
			usersList = ur.findAll();

			for (User u : usersList) {
				user.add(mapUserToUserDto(u));
			}
		} catch (Exception e) {
			logger.info("Exception occured here in userservice implementation class find all()");
		}
		return user;
	}

	private UserDto mapUserToUserDto(User u2) {

		return UserDto.builder().email(u2.getEmail()).comments(u2.getComments()).build();

	}
	//batch scheduler---------------------------

	@Scheduled(cron = "10 * * * * *")
	//@Scheduled()
	public void examplesceduler() {
		try {

			Date date = new Date();
			String stringDateFormat = "hh:mm:ss ";
			DateFormat dateFormat = new SimpleDateFormat(stringDateFormat);

			// get current time
			String formattedDateAsString = dateFormat.format(date);

			System.out.println("this method will execute after every 5 sec " + formattedDateAsString);
		} catch (DateTimeException e) {
			e.printStackTrace();
			logger.info("date time exception");
		}
	}
//pagination---------------------------------------
	public Page<User> findPage(Pageable page) {
		return ur.findAll(page);

	}

	public List<User> getValues(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<User> data = ur.findAll(pageable);
		try {
			ur.deleteAll(data.getContent());
		} catch (Exception e) {
			logger.info("Exception in getvalues() paginagtion concept");
		}
		return data.getContent();

	}
	
	
	public List<User> sortByName(){
		List<User> us=null;
		us=ur.findbyNameSorted("ankith");

		
		return us;
		
	}
	
	
	
	
	
}