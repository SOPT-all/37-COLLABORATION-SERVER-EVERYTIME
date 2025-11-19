package com.everytime.domain.market.controller;

import com.everytime.domain.market.dto.response.MarketResponse;
import com.everytime.domain.market.service.MarketService;
import com.everytime.global.exception.constant.MarketSuccessCode;
import com.everytime.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/market")
public class MarketController {

    private final MarketService marketService;

    @GetMapping
    public BaseResponse<List<MarketResponse>> getMarketList() {
        List<MarketResponse> response = marketService.getMarket();
        return BaseResponse.ok(MarketSuccessCode.GET_MARKET_LIST.getMsg(), response);
    }
}
