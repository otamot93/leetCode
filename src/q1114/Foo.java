package q1114;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

class Foo {
    CountDownLatch second = new CountDownLatch(1);
    CountDownLatch third = new CountDownLatch(1);
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        if(second.getCount() != 0 ){
            second.await();
        }
        second.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        if(third.getCount() !=0){
            third.await();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
