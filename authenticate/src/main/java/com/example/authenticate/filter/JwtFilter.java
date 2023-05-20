package com.example.authenticate.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.authenticate.dto.CustomeUserDetails;
import com.example.authenticate.entity.User;
import com.example.authenticate.repository.UserRepository;
import com.example.authenticate.service.JwtService;
import com.example.authenticate.service.UserDetailsServiceImpl;
import com.netflix.discovery.converters.Auto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.hc.core5.http.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
public class JwtFilter extends OncePerRequestFilter {
    private final RequestMatcher uriMatcher1 = new AntPathRequestMatcher("/api/v1/authen/**", HttpMethod.POST.name());

    @Autowired
    JwtService jwtService;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var bearerToken = request.getHeader("Authorization");
        var jwt = "";
        if(bearerToken != null || !bearerToken.isEmpty() && bearerToken.startsWith("Bearer")){
            jwt = bearerToken.substring(7);
        }
        var username = jwtService.getUserName(jwt);
        User user = userRepository.findByUsername(username).orElseThrow();
        boolean isValidate = jwtService.deccodeJwt(jwt);

        if(isValidate){
            CustomeUserDetails principal = new CustomeUserDetails(user);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(principal, null, null));
        }
        filterChain.doFilter(request, response);
    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return uriMatcher1.matches(request);
    }
}
