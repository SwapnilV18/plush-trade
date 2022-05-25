package com.rovio.puzzlestudio.marketplace.model.item;

import com.rovio.puzzlestudio.marketplace.algo.GraphNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeableItem extends GraphNode {
    String name;
    int price;
}
