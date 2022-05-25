package com.rovio.puzzlestudio.marketplace.model.input.trading;

import com.rovio.puzzlestudio.marketplace.model.item.PlushToy;
import com.rovio.puzzlestudio.marketplace.model.item.TradeableItem;
import com.rovio.puzzlestudio.marketplace.model.market.TradeSetup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketSupply {
    List<PlushToy> plushes = new ArrayList<>();

    List<TradeSetup> trades = new ArrayList<>();

    Map<String,Integer> tradeToIndexMap = new HashMap<>();
}
