package concurrent.thread;

public class MyThread extends Thread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.interrupt();
        System.out.println(myThread.isInterrupted());
    }

    @Override
    public void run() {
        try {
            for(int i=0; i<500000; i++) {
                if(this.isInterrupted()) {
                    System.out.println("be interrupted");
                    throw new InterruptedException();
                }
                System.out.print(i+" ");
            }
            System.out.println("outside run");

        } catch (InterruptedException e) {

        }
    }
}
