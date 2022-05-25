package com.rovio.puzzlestudio.marketplace;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rovio.puzzlestudio.marketplace.algo.BFSForSSSPGraphTraversal;
import com.rovio.puzzlestudio.marketplace.algo.GraphUnweightedDirectionalAlgo;
import com.rovio.puzzlestudio.marketplace.market.impl.PlushMarketHelsinki;
import com.rovio.puzzlestudio.marketplace.processor.InputProcessor;
import com.rovio.puzzlestudio.marketplace.processor.OutputProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarketplaceApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MarketplaceApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        ApplicationContext ctx = SpringApplication.run(MarketplaceApplication.class, args);

        InputProcessor inputProcessor = (InputProcessor) ctx.getBean(InputProcessor.class);
        BFSForSSSPGraphTraversal bfsForSSSPGraphTraversal = (BFSForSSSPGraphTraversal) ctx.getBean(GraphUnweightedDirectionalAlgo.class);
        OutputProcessor outputProcessor = (OutputProcessor) ctx.getBean(OutputProcessor.class);
        PlushMarketHelsinki plushMarketHelsinki = new PlushMarketHelsinki(bfsForSSSPGraphTraversal, inputProcessor, outputProcessor);
        //Todo wire the actual inputs here or invoke a method which will do it.
        plushMarketHelsinki.calculateStrategy("", "");

    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }
}
