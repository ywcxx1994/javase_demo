package com.yw.design.behavior.dutyChain.myself;

public class Client {
    public static void main(String[] args) {
        Handler managerHandler = new ManagerHandler();
        Handler directorHandler = new DirectorHandler();
        Handler firstHandler = new FirstLeaderHandler();
        //组装责任链
        directorHandler.setHandler(managerHandler);
        firstHandler.setHandler(directorHandler);

        Request req = new Request();
        req.setName("envy");
        req.setDays(11);
        firstHandler.handler(req);
    }
}
