package com.rovio.puzzlestudio.marketplace.market;

public interface PlushMarket {

    /**
     * Calculates the right strategy for a offer for a particular market setup.
     *
     * @param offerJson  sample :{"plush": "Stella"}
     * @param marketJson sample :
     *                   {
     *                   "plushes": [
     *                   {"plush": "RedBird", "price": 80},
     *                   {"plush": "Stella", "price": 90},
     *                   {"plush": "Pig", "price": 75}
     *                   ],
     *                   "trades": [
     *                   {"take": "RedBird", "give": "Pig"},
     *                   {"take": "Pig", "give": "Stella"}
     *                   ]
     *                   }
     * @return the optimal stratergy to be taken to maximise profit.
     */
    String calculateStrategy(String offerJson, String marketJson);
}
