package com.line.design32;

/**
 * @author zsw
 * @date 2021/5/8 16:09
 * @description :
 */
public class PublicTransportStrategy implements TravelStrategy {
    @Override
    public int calculateMinCost() {
        return 50;
    }
}
