# Questions

## Real-World Scenarios + Questions
- Situation
  - Imagine you’re building a web server that handles multiple client requests. Without multithreading, the server processes one request at a time, making other clients wait.
  - Question
    - How would you design a system where multiple clients requests can be processed simultaneously?
  - Solution
    - To handle multiple incoming request efficiently we can use a thread pool
    - Each request is assigned to a thread in the pool, whcihc avoids the overhead of creating and destroying threads for every request.
    - In Java, the ExecutorService provides a convenient way to manage thread pools
    - This approach ensures better resouce utlization and scalability.
    - We can configure the thread pool size based on the expected workload and system resouces
    - Additionally consider handling rejected tasks gracefully if the pool reaches its maximum capacity
- Situation
  - We are developing a banking application that transfers money between accounts.If two threads try to transfer money between the same accounts in reverse order, a deadlock can occur
  - Question 
    - how would you prevent deadlock in this situation
  - Solution
    - acquire locks in consistent order(e.g. lock the Acc X first and then Acc Y)
    - Use timeouts when acquiring locks to detect and handle deadlocks
    - implement algorithms to detect and resolve deadlocks dynamically
- Situation
  - You're tasked with implementing a system where one thread produces data and another thread consumes it. The producer shoudl wait if buffer is full and consumer shoudl wait if the buffer is empty
    - How would you implement a producer consumer system with proper synchronization?
      - using low level synchronization methods like wait() and notify() to coordinate the producer and consumer threads
      - using blockingqueue which handles synchronization internally making the implementation simpler and more robust
      - using synchronized block to control access to the shared buffer and ensures proper synchronization
      - Overall 
        - for simplicity and reliability use blockingqueue
        - for custom synchronization logic or fine grained control we use wait() and notify() or synchronized block
- Situation
  - We need to build a stock price aggregator tha fetches price updates from multiple APIs concurrently
    - How would you design a system that fetches stock prices concurrently and aggregates the data?
      - Using ExecutorService
        - use a thread pool to fetch stock prices concurrently and aggregate the results
      - Using CompletableFuture
        - provides a more modern and functional approach to handle concurrency

## Key Concepts with Real time impact

- Multiple threads accessing shared resouce can lead to data inconsistency
  - use synchronization or locks to enure that only one thread can modify a resouce at a time
    - examples
      - booking systems for flight
      - inventory management systems in e-commerce
- Why Thread pooling
  - Creating a new thead is a expensive
  - a thread pool reuses existings theads to handle tasks efficiently
  - examples
    - web servers like apache or nginx
    - payment gateways processing multiple transactions
- deadlock and starvation
  - two or more threads wait for each other indefinitely
  - a thread waits forever due to lack of CPU time
    - examples
      - database transactions with multiple locks
      - parallel data processing with dependent tasks

