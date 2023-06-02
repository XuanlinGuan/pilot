package com.pilot.aopcake.service;

import com.pilot.aopcake.entity.Cake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CakeCreationService {

    private Logger logger = LoggerFactory.getLogger("Cake Service");



    public Cake createChocolateCake(Cake cake) {

        logger.info("begin to bake Chocolate cake");

        cake.setFlavor("Chocolate");
        cake.setCreator("Guanbuliao");
        cake.setSizeType("11 inch");

        logger.info("The Chocolate cake is ready");

        return cake;
    }

    public Cake createBlueBerryCake(Cake cake) {
        logger.info("begin to bake BlueBerry cake");

        cake.setFlavor("BlueBerry");
        cake.setCreator("Guanbuliao");
        cake.setSizeType("11 inch");

        logger.info("The BlueBerry cake is ready");

        return cake;
    }

    public Cake createButterCake(Cake cake) {
        logger.info("begin to bake Butter cake");

        cake.setFlavor("butter");
        cake.setCreator("Guanbuliao");
        cake.setSizeType("11 inch");

        logger.info("The Butter cake is ready");

        return cake;
    }

    public Cake createOriginalCake(Cake cake) {

        logger.info("begin to bake Original cake");

        cake.setFlavor("Original");
        cake.setCreator("Guanbuliao");
        cake.setSizeType("11 inch");

        logger.info("The Original cake is ready");

        return cake;
    }
    /*
    * logger.warn("这里可以打出黄得瑟warn")
    * logger.error("这里可以打出 红色的 error")
    * logger.debug("only for debug purpose")
    * */


}
