package com.line.design32;

/**
 * @author zsw
 * @date 2021/5/8 16:20
 * @description :
 */
public class TravelService {
    private TravelStrategyFactory travelStrategyFactory = new TravelStrategyFactory();

    public int calculateMinCost(String travelWay) {
        TravelStrategy travelStrategy = travelStrategyFactory.createTravelStrategy(travelWay);
        return travelStrategy.calculateMinCost();
    }

    public static void main(String[] args) {
        TravelService travelService = new TravelService();
        int selfDriving = travelService.calculateMinCost("selfDriving");
        System.out.println(selfDriving);
    }
}
