package bigdata.hadoop;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Sup extends Sub{


    public Sup(String name) {
        System.out.println(name);
    }

    public void doSomeThing() {
        System.out.println("sout + ...");
    }

    public static void main(String[] args) {

        WeakReference<Sup> p = new WeakReference(new Sup("helk"));
        p.get().doSomeThing();

        SoftReference<Sup> sp = new SoftReference(new Sup("----"));
        sp.get().doSomeThing();
    }
}
