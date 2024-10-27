class Message {
    private String message;
    private boolean hasMessage = false;

    public synchronized void produceMessage(String msg) throws InterruptedException {
        while (hasMessage) {
            wait(); // Wait until the message is consumed
        }
        message = msg;
        hasMessage = true;
        System.out.println("Produced: " + message);
        notify(); // Notify the consumer
    }

    public synchronized void consumeMessage() throws InterruptedException {
        while (!hasMessage) {
            wait(); // Wait until there is a message to consume
        }
        System.out.println("Consumed: " + message);
        hasMessage = false;
        notify(); // Notify the producer
    }
}

class Producer extends Thread {
    private Message message;

    public Producer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            message.produceMessage("Hello");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private Message message;

    public Consumer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            message.consumeMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class waitNotif {
    public static void main(String[] args) {
        Message message = new Message();
        Producer producer = new Producer(message);
        Consumer consumer = new Consumer(message);

        producer.start();
        consumer.start();
    }
}

/*
 * In this example, we have a Message class that has two methods: produceMessage() and consumeMessage().
 * The produceMessage() method is used by the producer to produce a message, and the consumeMessage() method is used by the consumer to consume the message.
 * Both methods are synchronized to ensure that only one thread can access them at a time.
 * The producer thread calls the produceMessage() method to produce a message, and the consumer thread calls the consumeMessage() method to consume the message.
 * The producer thread waits until the message is consumed by the consumer thread, and the consumer thread waits until there is a message to consume.
 * The wait() and notify() methods are used to implement this synchronization.
 * The wait() method causes the current thread to wait until another thread calls the notify() method on the same object.
 * The notify() method wakes up a single thread that is waiting on the object.
 * In the main method, we create an instance of the Message class and two threads: a producer thread and a consumer thread.
 * We start both threads, and the producer thread produces a message, which is then consumed by the consumer thread.
 * The producer thread waits until the message is consumed, and the consumer thread waits until there is a message to consume.
 * This example demonstrates how to use the wait() and notify() methods to implement inter-thread communication in Java.
 * its a lot enik ariyam but it is java.
 */

/*
output:
Produced: Hello
Consumed: Hello
 */
