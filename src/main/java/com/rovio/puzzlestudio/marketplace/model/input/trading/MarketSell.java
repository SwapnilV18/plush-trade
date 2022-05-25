package com.rovio.puzzlestudio.marketplace.model.input.trading;

import com.rovio.puzzlestudio.marketplace.MarketAction;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarketSell implements MarketActivity {
    MarketAction action;
    String plush;
    Integer price;
}
