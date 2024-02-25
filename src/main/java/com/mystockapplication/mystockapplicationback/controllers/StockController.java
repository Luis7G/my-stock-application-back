package com.mystockapplication.mystockapplicationback.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mystockapplication.mystockapplicationback.model.Stock;
import com.mystockapplication.mystockapplicationback.repositories.StockRepository;

import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.InputStreamResource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//put core.io library
import org.springframework.core.io.Resource;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:3000")
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockRepository stockRepository;

    @GetMapping
    public Map<String, Object> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("data", stocks);
        return response;
    }

    @PostMapping
    public ResponseEntity<Stock> createProduct(@RequestBody Stock stock) {
        stockRepository.save(stock);
        return ResponseEntity.ok(stock);
    }

    @PatchMapping
    public ResponseEntity<Stock> updateProduct(@RequestBody Stock stock) {
        stockRepository.save(stock);
        return ResponseEntity.ok(stock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Stock> deleteProduct(@PathVariable String id) {
        stockRepository.deleteById(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
