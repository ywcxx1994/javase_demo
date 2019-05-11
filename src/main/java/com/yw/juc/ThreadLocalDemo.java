package com.yw.juc;

/**
 * @author:YanWei
 * @date: 2019/5/6 17:09
 * @desc: threadLocal的例子
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        QuerySvc qs = new QuerySvc();
        for (int k=0; k<10;k++){
            String sql = "Select * from table where id =" + k;
            new Work(qs,sql).start();
        }
    }
}

class QuerySvc {
    private String sql;
    private ThreadLocal sqlHolder = new ThreadLocal();

    public void execute() {
        System.out.println("Thread " + Thread.currentThread().getId() + " Sql is " + sql);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + Thread.currentThread().getId() + " Thread Local variable Sql is " + sqlHolder.get());
    }

    public String getSql() {
        return sql;
    }

    public  void setSql(String sql) {
        this.sql = sql;
        sqlHolder.set(sql);

    }

}

class Work extends Thread {

    private QuerySvc querySvc;
    private String sql;
    public Work(QuerySvc querySvc, String sql) {
        this.querySvc = querySvc;
        this.sql = sql;

    }
    @Override
    public void run() {
        querySvc.setSql(sql);
        querySvc.execute();
    }

}