package com.rovio.puzzlestudio.marketplace.algo;

import com.rovio.puzzlestudio.marketplace.model.item.TradeableItem;
import com.rovio.puzzlestudio.marketplace.model.market.Market;

public interface GraphUnweightedDirectionalAlgo {

    void addDirectedEdge(Market market, int i, int j);

    void algo(TradeableItem tradeableItem);
}
