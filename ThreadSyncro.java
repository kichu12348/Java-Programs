class Counter {
    int count;

    public synchronized void increment(String name) {
        count++;
        System.out.println("Thread " + name + " Count: " + count);
    }
}

class CounterThread extends Thread {
    Counter counter;
    String name;

    public CounterThread(Counter counter, String name) {
        this.counter = counter;
        this.name=name;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                counter.increment(name);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
}

public class ThreadSyncro {
   public static void main(String args[]){
        Counter counter = new Counter();
        CounterThread ct1 = new CounterThread(counter, "A");
        CounterThread ct2 = new CounterThread(counter, "B");
        try{
            ct1.start();
        ct2.start();
        
        ct1.join();
        ct2.join();
        }catch(InterruptedException e){
            System.out.println("Error: " + e);
        }
        System.out.println("Count: " + counter.count);
    }



}
