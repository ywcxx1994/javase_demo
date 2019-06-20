package com.yw.extend;

public class ZI extends FU {
    int num = 10;

    public ZI() {
        super();
        System.out.println(num);
        this.show();
    }

    public void show() {
        System.out.println("zi show" + num);
    }

    @Override
    protected void fuck(int fuck) {
        System.out.println("hello");
		/*if(fuck==1) {
			throw new FuckException("fuck you");
		}else {
			System.out.println("hello");
		}*/
    }
}
