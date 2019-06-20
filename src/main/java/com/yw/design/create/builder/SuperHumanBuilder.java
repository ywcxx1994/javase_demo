package com.yw.design.create.builder;

/**
 * 具体的制造人方法
 *
 * @author 18765
 */
public class SuperHumanBuilder implements IBuilderHuman {

    public Human human;

    public SuperHumanBuilder() {
        this.human = new Human();
    }

    @Override
    public void buildHead() {
        human.setHead("智商180的头脑");
    }

    @Override
    public void buildBody() {
        human.setBody("新的身体");

    }

    @Override
    public void buildHand() {
        human.setHand("新的手");
    }

    @Override
    public void buildFoot() {
        human.setFoot("新的脚");

    }

    @Override
    public Human createHuman() {
        return human;
    }

}
