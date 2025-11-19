package com.everytime.domain.market.service;

import com.everytime.domain.market.dto.response.MarketResponse;
import com.everytime.domain.market.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarketService {

    private final MarketRepository marketRepository;

    public List<MarketResponse> getMarket() {
        return marketRepository.findTop5ByOrderByCreatedAtDesc()
                .stream()
                .map(MarketResponse::from)
                .toList();
    }
}
