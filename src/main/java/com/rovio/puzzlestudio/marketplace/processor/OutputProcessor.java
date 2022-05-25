package com.rovio.puzzlestudio.marketplace.processor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rovio.puzzlestudio.marketplace.MarketAction;
import com.rovio.puzzlestudio.marketplace.model.input.trading.Actions;
import com.rovio.puzzlestudio.marketplace.model.input.trading.MarketActivity;
import com.rovio.puzzlestudio.marketplace.model.input.trading.MarketSell;
import com.rovio.puzzlestudio.marketplace.model.input.trading.MarketTrade;
import com.rovio.puzzlestudio.marketplace.model.item.TradeableItem;
import com.rovio.puzzlestudio.marketplace.util.io.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OutputProcessor {

    private final JsonUtil jsonUtil;

    public static Comparator<TradeableItem> valueComparator = new Comparator<TradeableItem>() {
        @Override
        public int compare(TradeableItem o1, TradeableItem o2) {
            return o2.getPrice() - o1.getPrice();
        }
    };

    public void print(List<TradeableItem> optimalTradeItems) throws JsonProcessingException {
        Actions actions = new Actions();
        List<MarketActivity> marketActivityList = new ArrayList<>();

        for (int i = optimalTradeItems.size() - 1; i > 0; i--) {
            TradeableItem give = optimalTradeItems.get(i);
            TradeableItem take = optimalTradeItems.get(i - 1);
            marketActivityList.add(createMarketTrade(give.getName(), take.getName()));
        }
        marketActivityList.add(createMarketSell(optimalTradeItems.get(0)));
        actions.setActions(marketActivityList);
        log.info(jsonUtil.createJsonFromObject(actions));
    }

    private MarketTrade createMarketTrade(String giverName, String takerName) {
        return new MarketTrade(MarketAction.trade, giverName, takerName);
    }

    private MarketSell createMarketSell(TradeableItem offerTradeableItem) {
        return new MarketSell(MarketAction.sell, offerTradeableItem.getName(), offerTradeableItem.getPrice());
    }
}
