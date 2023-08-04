package com.example.wantedBoard.service;

import com.example.wantedBoard.model.Criminal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WantedBoardService {

    private final FBIAPIService fbiApiService;

    public WantedBoardService(FBIAPIService fbiApiService) {
        this.fbiApiService = fbiApiService;
    }

    public List<Criminal> getAllCriminals() {
        return fbiApiService.fetchCriminals();
    }

}
