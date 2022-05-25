package com.rovio.puzzlestudio.marketplace.market.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rovio.puzzlestudio.marketplace.algo.BFSForSSSPGraphTraversal;
import com.rovio.puzzlestudio.marketplace.market.PlushMarket;
import com.rovio.puzzlestudio.marketplace.model.item.TradeableItem;
import com.rovio.puzzlestudio.marketplace.model.market.Market;
import com.rovio.puzzlestudio.marketplace.processor.InputProcessor;
import com.rovio.puzzlestudio.marketplace.processor.OutputProcessor;
import com.rovio.puzzlestudio.marketplace.util.io.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PlushMarketHelsinki implements PlushMarket {

    private final BFSForSSSPGraphTraversal bfsForSSSPGraphTraversal;
    private final InputProcessor inputProcessor;
    private final OutputProcessor outputProcessor;

    @Override
    public String calculateStrategy(String offerJson, String marketJson) {
        // PlushMarket offer, marketSetup;
        try {
            // offer = new ObjectMapper().readValue(offerJson, PlushMarket.class);
            // marketSetup = new ObjectMapper().readValue(marketJson, PlushMarket.class);
            //drive the algo.

            Market marketFinland = inputProcessor.processMarket();
            TradeableItem offerTradeableItem = marketFinland.getNodeList().get(1);

            bfsForSSSPGraphTraversal.algo(offerTradeableItem);

            Collections.sort(marketFinland.getNodeList(), outputProcessor.valueComparator);
            List<TradeableItem> optimalStrategy = bfsForSSSPGraphTraversal.getNodeListWithParentElement(marketFinland.getNodeList());
            optimalStrategy.add(offerTradeableItem);
            outputProcessor.print(optimalStrategy);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
