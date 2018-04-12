package concurrent.thread;

public class TestThread extends Thread {


    private int count = 5;

    public TestThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + currentThread().getName()
                    + " 计算，count=" + count);
        }
    }


    public static void main(String[] args) {

        TestThread mythread=new TestThread("A");
        //线程a b c启动的时候，执行的是myThread的方法，此时数据共享
        Thread a=new Thread(mythread,"A");
        Thread b=new Thread(mythread,"B");
        Thread c=new Thread(mythread,"C");

        a.start();
        b.start();
        c.start();
    }



}
