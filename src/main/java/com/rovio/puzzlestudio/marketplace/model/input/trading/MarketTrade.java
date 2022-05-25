package com.rovio.puzzlestudio.marketplace.model.input.trading;

import com.rovio.puzzlestudio.marketplace.MarketAction;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarketTrade implements MarketActivity {
    MarketAction action;
    String give;
    String take;
}
