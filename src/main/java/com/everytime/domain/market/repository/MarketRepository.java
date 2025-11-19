package com.everytime.domain.market.repository;

import com.everytime.domain.market.domain.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {

    List<Market> findTop5ByOrderByCreatedAtDesc();
}
