package com.yw.design.create.builder;

public interface IBuilderHuman {
    public void buildHead();

    public void buildBody();

    public void buildHand();

    public void buildFoot();

    public Human createHuman();
}
