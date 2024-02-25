package com.mystockapplication.mystockapplicationback.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mystockapplication.mystockapplicationback.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}