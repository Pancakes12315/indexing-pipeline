package com.indexingpipeline.producer;

import redis.clients.jedis.Jedis;

public class Producer {
    public static void main(String[] args) {
        try (Jedis jedis = new Jedis("localhost", 6379)) {
            for (int i = 0; i < 100; i++) {
                String item = "Item " + i;
                jedis.lpush("events", item); // push to Redis list
                System.out.println("Produced: " + item);

                // Optional: simulate delay
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
