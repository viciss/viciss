package net.samhouse;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;

public class testQuasar {
    public static void t1(String ss) {
        new Fiber<String>() {
            private static final long serialVersionUID = 1L;

            @Override
            protected String run() throws SuspendExecution, InterruptedException {
                System.out.println(" in fiber...");
                return "---";
            }
        }.start();
    }

    public static void main(String[] args) {
        t1("in ?");
    }
}
