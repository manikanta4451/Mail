package com.Mail.example.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Mail.example.Dto.UserDto;
import com.Mail.example.Entity.User;
import com.Mail.example.Service.UserServiceImpl;

@RestController
public class RegistrationController {
	@Autowired
	private JavaMailSender javamailsender;
	@Autowired
	UserServiceImpl usi;
	@Autowired
	UserServiceImpl userserviceimpl;
	
	private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	@RequestMapping("/jsppage")
	public String pegination(HttpServletRequest request) {

		request.setAttribute("name","home");
		return "mail";
	}

	@RequestMapping("/mani")
	public String signup() {

		try {
			logger.info("The Email is invoked and further it is processed");

			SimpleMailMessage mail = new SimpleMailMessage();
			List<String> userEmails = new ArrayList<String>();
			userEmails.add("manikantachinni22@gmail.com");
			userEmails.add("ajithgoud.aj@gmil.com");
			userEmails.add("manikantabaswa97@gmail.com");
			userEmails.add("ajithgoud55@gmail.com");
			for (String email : userEmails) {
				mail.setTo(email);
				mail.setSubject("Hi this is Testing email");
				mail.setText("hello");
				javamailsender.send(mail);
			}
			logger.info("The Email is ended");
		} catch (MailException e) {
			logger.error("Mail exception has occured", e);
			e.printStackTrace();
		}
		return "Email sent successfully ";

	}

	@RequestMapping("/mapper")
	public List<UserDto> findall() {
		return usi.findall();

	}

	// Batchscheduling---------------------------------------------
	@RequestMapping("/scheduler")
	public void scheduler() {
		userserviceimpl.examplesceduler();
	}

	// pagintion----------------------------------------------------

	@RequestMapping("/pageablecoding")

	public Page<User> fetchpage(Pageable page) {
		return userserviceimpl.findPage(page);

	}

	@RequestMapping(value = "/getValues", method = RequestMethod.GET)
	public List<User> getValue(@RequestParam int page, @RequestParam int size) {
		List<User> data = usi.getValues(page, size);
		return data;

	}
	@RequestMapping("/criteria")
	public List<User> byName(){
		
		List<User> lu=null;
		lu=userserviceimpl.sortByName();
		return lu;
		
	}

}
