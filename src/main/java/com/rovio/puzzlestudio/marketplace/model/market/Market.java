package com.rovio.puzzlestudio.marketplace.model.market;

import com.rovio.puzzlestudio.marketplace.model.item.TradeableItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Market {
    public List<? extends TradeableItem> nodeList;
}
