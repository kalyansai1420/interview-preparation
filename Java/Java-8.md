# Java 8 Interview Questions

1. Why can a stream be consumed only once ? What would happen if we try to reuse the same stream?

- A java stream can used oonly once because it works like a pipeline that processes data step by step and then finishes. When we perform a terminal operation like forEach(), collect(), or count(), the stream processes all elements and then gets closed automatically.

- Since the stream does not store date like a collection and only processes it once, it cannot be reused.If we try to use the same stream again, Java will throw an IllegalStateException saying that the stream has already been operated or closed. To process the data again,we must create a new stream 

2. Why do we need Stream if we can write code without stream API?

- we can write without Stream APi, but streams make the code shorted, cleaner and easier to read. Before streams, we mostly used lopps to filter, sort, or process data, which required many lines of code.

- Now with streams, we can do the same work in shorted way, meaning we just describe what we want to do instead of how to do it. Streams also support features like functional programming and easy parallel processing, which can imrpve performance in some cases. So, that's why sometimes stream is better than traditional coding.

3. Can you please explain stream pipeline structure?

- A Stream pipeline in java is the sequence of steps used to process data using streams. It mainly has 3 parts : Source, Intermediate Operations, and Terminal Operation. 
- The source is where data comes from, like a List, Set or array(list.stream()).
- Then we apply intermediate operations such as filter(), map(), or sorted() to transform the data; these operations only prepare the pipeline and do not run immediately.
- Finally, a terminal operation like forEach(), collect(), or count() is called, which triggers the execution runs, the stream is completed and cannot be reused.

4. Why are intermediate operations called lazy?

- Intermediate operations like filter(), map(), and sorted() are called lazy because they do not run immediately when they are written. They only prepare the pipeline. The actual processing starts only when a terminal operation like forEach(), or collect() is called. Until then, Java just remembers the steps but does not process the data.

5. If a stream a pipeline contains multiple filter() operations, does it iterate the collection multiple times? Explain.

- No, the collection is not iterated multiple times. In a stream pipeline, all intermediate oprerations are combined into a single pass. For each element, Java applies the first filter(), then the second filter(), and so on before moveing to next element. So the collection is traversed only once, whcih makes streams efficient.

6. You are debugging a Stream pipeline and want to check intermediate values wihtout affecting the reult. Which concept would you use and why?

- We could use the peek() method. It allows us to look at the elements while they are flowing through the stream pipeline without modifying them. This is useful for debugging, because we can print or log intermediate values without changing the final result.

7. You are processing a list of 10 million records using Streams. After applying multiple filters and a map operation, the performance becomes slow. What factors would you check to identify the problem ?

- First, we could check if operations inside filter() or map are heavy or slow. Second, we would check if unnecessary operations are used in the pipeline. Third, we would see if parallel streams could help improve performance. And we would also check if the object creation inside the stream is causing problematic. So these are factors we would check

8. A developer replaces a traditional loop with Streams but the code becomes harder to read. In what scenarios should Streams be avoided?

- Streams should be avoided when logic is very complex. In such cases, a simple loop may be easier to understand and maintain. Streams are best used for simple data processing like filtering, mapping, or collecting.


9. Can streams modify the original collection ?

- No, streams do not modify the original collection. Streams are mainly used to read and process data. They create a new result after operations like map(), or filter(), while the original collection remains unchanegd unless we modify it ourselves.

10. What is the difference between map() and flatMap() conceptually ? When would you prefer flatMap?

- map() is used to transform each element into another element. For example, converting a list of names to uppercase.

- whereas flatMap() is used when each element contains multiple values(like a list inside a list) and we want to flatten them into a single stream. We prefer flatMap() when working with nested collections, such as a list of lists.

11. Why is forEach() considered a terminal operation while peek() is intermediate?

- forEach() is a terminal operation becuase it triggers the execution of the stream pipeline and finishes the stream. After this, the stream cannot be used again. peek() is an intermediate operation because it just observes the elements in the pipeline and the stream continues to the next operation.

12. Why is Stream not a data structure?

- A stream is not a data structure becuase it does not store data. Instead, it is a just a way to process data from a source like a list, set or array. It simply flows the data through operations and produces a result that's why its not a data structure.

13. What happens if we modify the source collection while the stream is being processed ?

- If we modify the source collection while the stream is running, it can cause problems like ConcurrentModificationException or unexpected results. Streams expect the source data to remain unchanged during processing, so modifying it during execution is not recommended.

14. Can a Stream pipeline run without a terminal operation ?

- No, a stream pipeline cannot run without a terminal operation. Intermediate operations like filter() or map() build the pipeline, but they do not process the data. The stream actually starts processing only when a terminal operation forEach(), collect(), or count() is called.

15. What is Parallel Stream and how does java decide how many threads to use in a parallel stream?

- A Parallel stream is a stream that processing data using multiple threads at the same time to improve performance. We can create it using parallelStream() or stream().parallel(). Java usually decided the number of threads based on the number of CPU cores avaiable in the system.

16. Why can using Parallel Stream sometimes make performance worse instead of better?

- Parallel streams can be slower when the task is very small, because creating and managing multiple threads adds extra overhead. They can also be slower when there is too much synchronization, shared data, or complex operations, which reduces the benefit of parallel processing.

17. What kind of operations are not suitable for Parallel Streams?

- Operations that modify shared variables, depend on order, are not suitable for parallel streams. Also, very small or lightweight tasks are not good candidates becuase the overhead of parallelism can reduce performance.

18. Parallel Streams internally use which thread pool()? Can it affect other tasks ?

- Parallel streams internally use the ForkJoinPool.commonPool(). Since this pool is shared across the application, heavy parallel stream tasks can occupy the threads and affect other tasks that also depend on the same pool.

19. If a stream operation depends on previous results, should we use Paralle Streams? Why? 

- No, we should avoid Parallel Streams in this case. Parallel streams process elements simultaneously in different threads, so the order of execution is not guaranteed. If an operation depends on the result of the previous element, parallel processing can give incorrect or unpredictable results.

20. When would we prefer sequential streams over parallel streams?

- We should prefer sequential streams when the data size is small, when the operations are simple, or when the logic depends on order or shared data. In these cases, sequential streams are simpler, safer, and sometimes even faster than parallel streams.

21. What makes an interface a Functional Interface? Can it have multiple methods?

- A functional interface is an interface that has only one abstract method. It can have multiple default methods or static methods, but only one abstract method is allowed. And we could use these functional interface in lambda expressions.

22. Why does Java allow multiple default methods in a functional interface but only one abstract method ?

- Java allows multiple default methods becuase they already have an implementation, so they do not affect the main purpose of the interface. But only one abstract method is allowed because lambda expressions need one clear method to implement.

23. Can a Functional Interface extend another interface ? What happens if both have abstract methods?

- Yes, a Functional Interface can extend another interface. But if both interfaces together result in more than one abstract method, then it will no longer be a functional interface and cannot be used with lambda expression.

24. What is the purpose of the @FunctionalInterface annotation if it is optional?

- The @FunctionalInterface annotation is used to tell the compiler that the interface should have only one abstract method. It is optional, but it helps the compiler check and give an error if someone accidentally adds another abstract method. So it mainly helps in code safety and clarity.

25. Can a functional interfaces contain static methods ?

- Yes, a functional interface can contain static methods. The only rule is that it must have exactly one abstract method. Static methods are allowed because they already have an imeplementation.

26. Give some examplels of funcitional interface?

- Some common examples  of funtional interfaces in Java re Runnable, Callable, Comparator, and interfaces from java.util.function like Predicate, Function, Consumer, and Supplier.

27. Why does Comparator qualify as a functional interface even though it has many methods ?

- Comparator is still a functional interface because it has only one abstract method, which is compare(). The other methods like reversed() or thenComparing() are default or static methods, so they already have implementation and do not break the functional interface rule.

28. What is the difference between Predicate, Function, Consumer, and Supplier conceptually ?

- Conceptually, these interfaces represent different types of operations. Predicate takes a value and returns true or false( used for conditions). Function takes a value and returns another value after transformation. Consumer takes a value and performs some action but returns nothing. Supplier does not take a value but returns some value.

29. How does the compiler determine which method a lambda expression refers to ?

- The compiler checks the functional interface type where the lambda is used. Since a functional interface has only one abstract method, the compiler automatically understands that the lambda expression implements that method.

30. Why must variables use inside lambda expressions be final or effectively final ?

- Variables used inside a lambda must be final or effectively final so their value does not change while the lambda is using them. This helps avoid problems with unexpected value changes and thread safety.

31. What does `effectively final` mean ?

- `Effectively final` means the variable is not declared with the final keyword, but its value is assigned only once and never changed later. In such cases, Java treats it like a final variable.

32. What is the difference between lambda expressions and anonymous class ?

- A lambda expression is a short and simple way to implement a functional interface with less code. Whereas an anonymous class is more detailed and can contain multiple methods and more structure. Lambdas are mainly used when we only need to implement one method quickly.

33. Can lambda expressions access instance variables and static variables ?

- Yes, lambda expressions can access both instance variables and static variables of the class. These variables do not need to be final, unlike local variables

34. Why can't we use lambda expressions without a functional interface ?

- Lambda expressions are designed to implement the single abstract method of a functional interface. If there is no functional interface, the compiler does not know which method the lambda should implement, so it cannot work.