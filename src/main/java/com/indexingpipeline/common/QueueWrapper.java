package com.indexingpipeline.common;

import java.util.LinkedList;
import java.util.Queue;

public class QueueWrapper {
    private final Queue<Event> queue = new LinkedList<>();

    public synchronized void publish(Event event) {
        queue.add(event);
        notifyAll(); // notify consumers
    }

    public synchronized Event consume() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        return queue.poll();
    }
}
