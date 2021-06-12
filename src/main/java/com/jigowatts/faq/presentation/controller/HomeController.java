package com.jigowatts.faq.presentation.controller;

import com.jigowatts.faq.application.service.IdsService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final IdsService idsService;

    @CrossOrigin
    @GetMapping
    public String home() {
        return "Hello world!";
    }

    @CrossOrigin
    @GetMapping(value = "/order/number")
    public String orderNumber() {
        var orderNumber = idsService.publish();
        return orderNumber.toString();
    }
}
