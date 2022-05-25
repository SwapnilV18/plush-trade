package com.rovio.puzzlestudio.marketplace.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(exclude = {"parent", "neighbours"})
@NoArgsConstructor
public class PlushToy extends TradeableItem {

    @JsonProperty("plush")
    String plush;
    @JsonProperty("price")
    int price;

    public PlushToy(String plush, int price) {

        super(plush, price);
    }
}
