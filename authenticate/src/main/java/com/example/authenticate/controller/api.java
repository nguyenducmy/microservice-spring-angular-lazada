package com.example.authenticate.controller;

import com.example.authenticate.dto.BaseResponse;
import com.example.authenticate.dto.UserDto;
import com.example.authenticate.entity.User;
import com.example.authenticate.repository.UserRepository;
import com.example.authenticate.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/authen")
@CrossOrigin(origins = "http://localhost:4200/")
public class api {
    @Autowired
    JwtService jwtService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse> register(@RequestBody User user) {
        Optional<User> isUser = userRepository.findByUsername(user.getUsername());
        BaseResponse baseResponse = new BaseResponse();
        if(isUser.isEmpty()){
            String password = new BCryptPasswordEncoder().encode(user.getPassword());
            user.setPassword(password);
            userRepository.save(user);
            baseResponse.setCode("200");
            baseResponse.setStatus("Register Done");
        }else{
            baseResponse.setCode("200");
            baseResponse.setStatus("User Existed");
        }
        return ResponseEntity.ok(baseResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse> login(@RequestBody UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername()).orElseThrow();
        var jwt = "";
        var baseResponse = new BaseResponse();
        if (user.getUsername().equals(userDto.getUsername())
                && new BCryptPasswordEncoder().matches(userDto.getPassword(), user.getPassword())) {
            jwt = jwtService.generate(userDto.getUsername());
            baseResponse.setStatus("Login Successfully");
            baseResponse.setCode("200");
            baseResponse.setObject(jwt);
        } else {
            baseResponse.setCode("403");
            baseResponse.setStatus("UnAuthorization");
            baseResponse.setObject("N/A");
        }

        return ResponseEntity.ok(baseResponse);
    }
}
