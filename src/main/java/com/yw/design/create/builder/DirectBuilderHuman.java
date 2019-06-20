package com.yw.design.create.builder;

public class DirectBuilderHuman {
    /**
     * 具体的建造人方法
     *
     * @param builderHuman
     * @return
     */
    public Human directBuild(IBuilderHuman builderHuman) {
        builderHuman.buildHead();
        builderHuman.buildBody();
        builderHuman.buildHand();
        builderHuman.buildFoot();
        return builderHuman.createHuman();
    }
}
