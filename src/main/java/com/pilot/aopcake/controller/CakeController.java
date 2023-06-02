package com.pilot.aopcake.controller;

import java.util.Random;
import com.pilot.aopcake.entity.Cake;
import com.pilot.aopcake.service.CakeCreationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CakeController {

    private Logger logger = LoggerFactory.getLogger("Controller level");
    @Autowired
    private CakeCreationService cakeCreationService;

    @PostMapping(value = "/create/cake")
    @ResponseBody
    public Cake createNewCake( @RequestBody Cake cake) {

        Cake cakeAllSet;

        logger.info("receive order to bake " + cake.getFlavor() + " cake ." );

        if (cake.getFlavor().equals("random")) {
            String[] cakeFlavors = {"Butter", "Blueberry", "Chocolate", "original" };
            Random random = new Random();
            int randomIndex = random.nextInt(cakeFlavors.length);
            String selectedCakeFlavor = cakeFlavors[randomIndex];
            cake.setFlavor(selectedCakeFlavor);
        }

        switch (cake.getFlavor()) {
            case "Butter" : {
                cakeAllSet =  cakeCreationService.createButterCake(cake);
                logger.info(" deliver the " + cake.getFlavor() + " cake to customer." );
                return cakeAllSet;
            }

            case "Blueberry" : {
                cakeAllSet =  cakeCreationService.createBlueBerryCake(cake);
                logger.info(" deliver the " + cake.getFlavor() + " cake to customer." );
                return cakeAllSet;
            }

            case "Chocolate" : {
                cakeAllSet =  cakeCreationService.createChocolateCake(cake);
                logger.info(" deliver the " + cake.getFlavor() + " cake to customer." );
                return cakeAllSet;
            }
        }

        cakeAllSet = cakeCreationService.createOriginalCake(cake);
        logger.info(" deliver the " + cake.getFlavor() + " cake to customer." );
        logger.warn("check the logger warn");
        logger.error("check the red error");
        logger.debug("only for debug");

        return cakeAllSet;
    }

}
