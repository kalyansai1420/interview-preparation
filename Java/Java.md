# Java interview quesions

- Volatile 
  - variable's value can be modified by multiple threads 
  - important in multithreaded environment to properly ensure synchronization and visibility of variable's state
- CopyOnWriteArrayList
  - thread safe variant of arrayList
  - use in concurrent environments where read operatios are more frequent than write operations
- AtomicInteger
  - class used to perform atomic operations on an int value
  - atomic operations are operations that are performed in a single step without the possibility of interference from other threads.
  - this means multiple threads might be updating the same integer value
