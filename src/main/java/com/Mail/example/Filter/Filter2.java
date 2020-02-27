package com.Mail.example.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
@Order(2)
public class Filter2 implements Filter {

		private static final Logger logger = LoggerFactory.getLogger(Filter1.class);
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

	}


