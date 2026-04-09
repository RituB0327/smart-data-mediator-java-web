package com.smartmediator.controller;

import com.smartmediator.entity.QueryHistory;
import com.smartmediator.repository.QueryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class HistoryController {

@Autowired
QueryRepository queryRepository;

@GetMapping("/history")

public List<QueryHistory> getHistory(){

return queryRepository.findAll();

}

}