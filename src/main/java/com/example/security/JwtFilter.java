package com.example.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.util.JwtUtili;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class JwtFilter extends OncePerRequestFilter{
	   @Autowired
	    private JwtUtili jwtUtil;
	
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterchain) throws ServletException, IOException{
	String	authorizationHeader = request.getHeader("Authorization");
	String	token =null;
	String	userName = null;
		  if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
	            token = authorizationHeader.substring(7);
	            userName = jwtUtil.extractUserName(token);
	        }

	        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	            if (jwtUtil.validateToken(token, userName)) {
	                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userName, null, null);
	                SecurityContextHolder.getContext().setAuthentication(authToken);
	            }
	        }
	        filterchain.doFilter(request, response);
	    }
	}	