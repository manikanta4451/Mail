package com.Mail.example.Filter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
@Order(1)
public class Filter1 implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(Filter1.class);
	
		//@Scheduled(fixedRate=3000)
	@Scheduled(cron = "5 * * * * *")
		public void exampleOfFoxedrate() {
		try {
			
		
		 Date date = new Date();
		     String stringDateFormat = "hh:mm:ss ";
		     DateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
		     
		     //get current time
		     String formattedDateAsString= dateFormat.format(date);
		        
		 System.out.println("this method will execute after every 5 sec "+ formattedDateAsString);
		}
		catch(DateTimeException e) {
			logger.info("date time exception is occured ");
		}
	}
	
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
	        logger.info( "Starting a transaction for req : {}", 
	        
	          req.getRequestURI());
	  
	        chain.doFilter(request, response);
	        logger.info("Committing a transaction for req : {}", 
	          req.getRequestURI());
		
	}
	
	@Bean
	public FilterRegistrationBean<Filter2> loggingFilter(){
	    FilterRegistrationBean<Filter2> registrationBean  = new FilterRegistrationBean<>();
	         try {
	        	 
	         
	    registrationBean.setFilter(new Filter2());
	    registrationBean.addUrlPatterns("/mani");
	         }
	         catch(BeansException e) {
	        	 logger.info("Beansexception has occured");
	         }
	         
	    return registrationBean;    
	}
	
	

}
