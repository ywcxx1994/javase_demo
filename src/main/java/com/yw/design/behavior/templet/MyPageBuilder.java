package com.yw.design.behavior.templet;

public class MyPageBuilder extends AbstractPageBuilder {

    @Override
    protected void appendHead(StringBuffer stringBuffer) {
        stringBuffer.append("<head><title>你好</title></head>");
    }

    @Override
    protected void appendBody(StringBuffer stringBuffer) {
        stringBuffer.append("<body><h1>你好,世界！</h1></body>");
    }

    public static void main(String[] args) {
        PageBuilder pageBuilder = new MyPageBuilder();
        System.out.println(pageBuilder.bulidHtml());
    }

}
