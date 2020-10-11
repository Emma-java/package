package com.guangzhou.converted.controller;

import com.guangzhou.converted.service.DigitsInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2020/20/11
 */
@RestController
public class DigitsController {

    @Autowired
    private DigitsInputService digitsInputService;

    public void digits(){
        digitsInputService.digitsToWrite();
    }
}
