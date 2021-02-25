package com.knb.mdtimemanagement.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/public")
public class TestController {

    @GetMapping(value = "/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Welcome to Minh Dang time management web services");
    }
}
