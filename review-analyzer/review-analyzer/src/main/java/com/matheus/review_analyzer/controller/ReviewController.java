package com.matheus.review_analyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analyze")
public class ReviewController {

    @GetMapping
    public String helloAnalyzer() {
        return "Review Analyzer API is running 🚀";
    }
}
