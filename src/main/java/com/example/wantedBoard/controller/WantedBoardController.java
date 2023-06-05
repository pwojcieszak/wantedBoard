package com.example.wantedBoard.controller;

import com.example.wantedBoard.model.Criminal;
import com.example.wantedBoard.service.WantedBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WantedBoardController {
    private final WantedBoardService wantedBoardService;

    public WantedBoardController(WantedBoardService wantedBoardService) {
        this.wantedBoardService = wantedBoardService;
    }

    @GetMapping("/wanted")
    public String getAllCriminals(Model model){
        model.addAttribute("criminals", wantedBoardService.getAllCriminals());
        return "wanted";
    }
}
