package com.rovio.puzzlestudio.marketplace.model.input.trading;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Actions {
    List<MarketActivity> actions;
}
