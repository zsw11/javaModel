package com.line.design32;

/**
 * @author zsw
 * @date 2021/5/8 16:07
 * @description :
 */
public class TravelStrategyFactory {
    public TravelStrategy createTravelStrategy(String travelWay) {
        if ("selfDriving".equals(travelWay)) {
            return new SelfDrivingStrategy();
        } if ("bicycle".equals(travelWay)) {
            return new BicycleStrategy();
        } else {
            return new PublicTransportStrategy();
        }
    }
}
