package com.guangzhou.converted.controller;

import com.guangzhou.converted.service.DigitsInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2020/20/11
 */
@RestController
@RequestMapping("/digits")
public class DigitsController {

    @Autowired
    private DigitsInputService digitsInputService;

    @PostMapping("/converted")
    public ResponseEntity digits(String number){
     return ResponseEntity.ok(digitsInputService.digitsToWrite(number));
    }
}
