package com.rovio.puzzlestudio.marketplace.algo;

import com.rovio.puzzlestudio.marketplace.model.item.TradeableItem;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Data
public class GraphNode {
    public int index;
    public boolean isVisited = false;
    public Optional<TradeableItem> parent = Optional.empty();
    public ArrayList<TradeableItem> neighbours = new ArrayList<>();


}
