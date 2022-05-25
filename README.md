# plush-trade
trading and selling with plush toys

To run:
Make changes to hardcoded data in InputProcessor.

1. Make changes to inputJson for the market entries as seen in the assignment pdf.
2. Add possible trades by adding the directedges in addDirectionalEdgesForTrades()method in Input procerssor
3. Now control the offered Plush toy by changing which of the plush from the nodelist we want to select
   TradeableItem offerTradeableItem = marketFinland.getNodeList().get(1);// search this line in code base.
   The offer search could be soemthing out of the nodelist as in one of the example in assignment. 

The projec should
1. Read input in json format
2. Send output in json format
3. Apply correct algo to make mimimum no of trades
4. Apply correct algo to make minumum no of trades to finally arrive at a toy which will give max profit
5. Coverage (likely 100% given the criteria)
6. Design principles
7. Coverage
8. Documentation.
9. Immutable dependency
10. Memorization if the trades are going to be constant and the offer plush will keep on changing
11. performance measurements.
12. Likelihood of trying other algos to check performance gain if any.
13. Memory utilization.
