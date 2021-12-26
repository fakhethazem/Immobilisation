package com.tekup.Immobilisation;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tekup.Immobilisation.Services.MyclientDetailService;
@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	 private JwtUtil jwtUtil;
	
	@Autowired
	 private MyclientDetailService myclientDetailService;
	 
//javainuse  eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYWxlbSIsImV4cCI6MTYzNzA5NjMzNiwiaWF0IjoxNjM3MDc4MzM2fQ._QEiUr7NdT0uVdxZSH-sUv_MNFcch4DnZMvqmkzzQcalj4qn2emD8ZxS2h8kEFjOkTILA6IRjfQQw5Nwh6YXLQ
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = null;
		String name =null;
		String authorizationheader=request.getHeader("Authorization");
		if(authorizationheader != null && authorizationheader.startsWith("Bearer")) {
			
			token=authorizationheader.substring(7);
			name=jwtUtil.getUsernameFromToken(token);
		}
			if (name!= null && SecurityContextHolder.getContext().getAuthentication() == null)
			{
				UserDetails userDetails=this.myclientDetailService.loadUserByUsername(name);
				if (jwtUtil.validateToken(token, userDetails)) {

					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					// After setting the Authentication in the context, we specify
					// that the current user is authenticated. So it passes the
					// Spring Security Configurations successfully.
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
			filterChain.doFilter(request, response);
			
		}
	}
	


