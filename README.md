# Real-Time Indexing Pipeline + Observability

## Tech Stack
Java, Docker, Elasticsearch, Prometheus, Grafana

## How it Works
1. **Producer** emits `ItemCreated` events to a queue.
2. **Consumer/Indexer** reads events and indexes into Elasticsearch.
3. **Metrics** are exposed via Micrometer to Prometheus.
4. **Grafana** dashboards visualize metrics.

## Setup Redis on Windows

1. Download Redis for Windows: [https://github.com/tporadowski/redis/releases](https://github.com/tporadowski/redis/releases)  
2. Unzip Redis to a folder, e.g., `C:\Redis`.  
3. Open PowerShell and start Redis server:
    ```powershell
    cd C:\Redis
    .\redis-server.exe
    ```
   > Leave this running while using the application.

---

## Build the Project

1. Clone or download the project.
2. Open PowerShell in the project folder.
3. Run:
    ```powershell
    mvn clean install -U
    ```

---

## Running the Application

1. Start the **Indexer** first (it will consume items from the queue):
    ```powershell
    mvn exec:java "-Dexec.mainClass=com.indexingpipeline.consumer.Indexer"
    ```
2. In a separate terminal, start the **Producer** (it will produce items):
    ```powershell
    mvn exec:java "-Dexec.mainClass=com.indexingpipeline.producer.Producer"
    ```
3. You should see the Producer generating items and the Indexer consuming them in real-time.

---

## Notes

- The `Queue` class was renamed to `QueueWrapper` to avoid conflicts with `java.util.Queue`.
- Log4j is configured automatically; no additional setup is needed.
- Tested on Windows with VSCode.
- Redis must be running before starting the Producer and Indexer.

---

