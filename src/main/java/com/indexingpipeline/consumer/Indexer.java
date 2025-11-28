package com.indexingpipeline.consumer;

import redis.clients.jedis.Jedis;
import java.util.List;

public class Indexer {
    public static void main(String[] args) {
        try (Jedis jedis = new Jedis("localhost", 6379)) {
            System.out.println("Indexer started. Waiting for events...");
            
            while (true) {
                // BRPOP blocks until an item is available
                List<String> item = jedis.brpop(0, "events");
                System.out.println("Indexed: " + item.get(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
