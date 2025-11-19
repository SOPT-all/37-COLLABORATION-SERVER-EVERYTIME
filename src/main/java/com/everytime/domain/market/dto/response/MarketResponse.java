package com.everytime.domain.market.dto.response;

import com.everytime.domain.market.domain.Market;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MarketResponse {

    private Long id;
    private String bookImgUrl;
    private String title;
    private int price;

    public static MarketResponse from(Market market) {
        return MarketResponse.builder()
                .id(market.getId())
                .bookImgUrl(market.getBookImgUrl())
                .title(market.getTitle())
                .price(market.getPrice())
                .build();
    }
}
