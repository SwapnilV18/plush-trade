package com.rovio.puzzlestudio.marketplace.processor;

import com.rovio.puzzlestudio.marketplace.algo.GraphUnweightedDirectionalAlgo;
import com.rovio.puzzlestudio.marketplace.model.input.trading.MarketSupply;
import com.rovio.puzzlestudio.marketplace.model.item.PlushToy;
import com.rovio.puzzlestudio.marketplace.model.market.Market;
import com.rovio.puzzlestudio.marketplace.util.io.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InputProcessor {

    private final JsonUtil jsonUtil;

    private final GraphUnweightedDirectionalAlgo graphUnweightedDirectionalAlgo;


    //Todo Create a map based on Plushes name and the index they end in
    //List<TradeSetup> tradeSetups = marketSupply.getTrades();
    //populateTradeToIndexMap(tradeableItems,marketSupply.getTradeToIndexMap());
    //Setup market with provided TradeableItemList
    @SneakyThrows
    public Market processMarket() {

        String inputJson = "{\"plushes\": [\n" +
                "    {\"plush\": \"RedBird\", \"price\": 80},\n" +
                "    {\"plush\": \"Stella\", \"price\": 90},\n" +
                "    {\"plush\": \"Pig\", \"price\": 75}\n" +
                "],\n" +
                "\"trades\": [\n" +
                "    {\"take\": \"RedBird\", \"give\": \"Pig\"},\n" +
                "    {\"take\": \"Pig\", \"give\": \"Stella\"}\n" +
                "]}";

        MarketSupply marketSupply = getMarketSupply(inputJson);
        List<PlushToy> tradeableItems = marketSupply.getPlushes();

        Market marketFinland = new Market(tradeableItems);
        addDirectionalEdgesForTrades(marketFinland);
        return marketFinland;
    }

    private void addDirectionalEdgesForTrades(Market marketFinland) {
        graphUnweightedDirectionalAlgo.addDirectedEdge(marketFinland, 0, 2);
        graphUnweightedDirectionalAlgo.addDirectedEdge(marketFinland, 2, 1);
    }

    private MarketSupply getMarketSupply(String inputJson) throws IOException {
        return (MarketSupply) jsonUtil.createObjectFromJson(inputJson, MarketSupply.class);
    }

}
