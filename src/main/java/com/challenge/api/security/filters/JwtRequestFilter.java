package com.challenge.api.security.filters;

import com.challenge.api.security.helper.SecurityConstants;
import com.challenge.api.security.service.JwtTokenHelper;
import com.challenge.api.security.service.JwtUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        try {
            log.info("INTERCEPT URL {}", request.getRequestURI());
            String header = request.getHeader(SecurityConstants.AUTHORIZATION);

            if (StringUtils.isEmpty(header) || !header.startsWith(SecurityConstants.BEARER)) {
                return;
            }

            String token = header.substring(7);
            String username = jwtTokenHelper.getUsernameFromToken(token);

            authenticate(request, response, token, username);
        } catch (Exception ex) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());
        } finally {
            chain.doFilter(request, response);
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response, String token, String username)
            throws IOException {
        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
        Boolean validateToken = jwtTokenHelper.validateToken(token, userDetails);

        if (validateToken) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                    = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, SecurityConstants.INVALID_TOKEN);
        }
    }

}
