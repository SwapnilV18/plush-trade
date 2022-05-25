package com.rovio.puzzlestudio.marketplace.algo;

import com.rovio.puzzlestudio.marketplace.model.item.TradeableItem;
import com.rovio.puzzlestudio.marketplace.model.market.Market;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BFSForSSSPGraphTraversal implements GraphUnweightedDirectionalAlgo {

    /**
     * Refer <a href="https://en.wikipedia.org/wiki/Dijkstras_algorithm ">Dijkstras Algo for SSSP graph weighted unidirectional</a>
     *
     * @param tradeableItem an tradeable entity in a Market.
     */
    @Override
    public void algo(TradeableItem tradeableItem) {
        LinkedList<TradeableItem> queue = new LinkedList<>();
        queue.add(tradeableItem);
        while (!queue.isEmpty()) {
            TradeableItem currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.println();
            for (TradeableItem neighbor : currentNode.getNeighbours()) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent = Optional.of(currentNode);
                }
            }
        }
    }

    public List<TradeableItem> getNodeListWithParentElement(List<? extends TradeableItem> tradeableItems) {
        List<TradeableItem> nodeWithParentElementList = new ArrayList<>();
        for (TradeableItem tradeableItem : tradeableItems) {
            if (tradeableItem.getParent().isPresent()) {
                nodeWithParentElementList.add(tradeableItem);
            }
        }
        return nodeWithParentElementList;
    }

    @Override
    public void addDirectedEdge(Market market, int i, int j) {
        TradeableItem first = market.getNodeList().get(i);
        TradeableItem second = market.getNodeList().get(j);
        first.getNeighbours().add(second);
    }
}
