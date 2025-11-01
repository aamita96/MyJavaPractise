# 📝 Summary: Java Multithreading 🚀 

[Link to the blog for - Multithreading in Java](https://engineeringdigest.medium.com/multithreading-in-java-39f34724bbf6)

This summary outlines key concepts covered in "Java Multithreading: Synchronization, Locks, Executors, Deadlock, CountdownLatch & CompletableFuture."

## I. Foundational Concepts 🧠

*   **CPU (Central Processing Unit):** The "brain of the computer" where programs run.
*   **Core:** An individual processing unit inside the CPU where the work actually happens.
    *   Historically, CPUs had a single core, but modern systems utilize multiple cores (e.g., quad-core, octa-core) to perform tasks simultaneously.
*   **Program:** A set of instructions designed to perform a task (e.g., Microsoft Word, OBS Studio).
*   **Process:** An instance of a program when it is running; the operating system (OS) starts a process corresponding to an open program.
*   **Thread:** The **smallest unit of execution within a process**.
    *   A process can have multiple threads, which share resources but can run independently (e.g., typing, spell checking, and auto-save within Microsoft Word).
*   **Multitasking (Higher Level):** Allows an OS to run multiple processes (applications) simultaneously.
    *   On a single-core CPU, this is achieved through **Time Sharing** (rapid switching between tasks).
    *   On multi-core CPUs, **True Parallel Execution** occurs, with tasks distributed across cores by the OS scheduler.
*   **Multithreading (Granular Level):** The ability to execute multiple threads concurrently within a **single process**.
    *   This enhances the efficiency of multitasking by breaking down individual tasks into smaller sub-tasks (threads).

### ⏱️ Time Slicing

*   **Definition:** Time slicing divides the CPU time into smaller intervals, often called "time slices" or "quanta" [1].
*   **Function:** The OS Scheduler 🤖 allocates these time slices to different processes and threads [1].
*   **Purpose:** The main goal is to ensure that every process and thread receives a fair share of CPU time [1, 2].
*   **Context:** In a single-core CPU, the OS achieves concurrency (multi-tasking) through "time sharing," which involves the rapid switching between tasks, facilitated by these time slices [1, 3, 4].

### 💾 Context Switching

*   **Definition:** Context switching is the fundamental process of saving the complete state (or context) of the currently running process or thread [2].
*   **Mechanism:** Once the current state is saved, the state of the next task chosen for execution is loaded [2]. The control then transfers to this new task, allowing it to resume execution from where it last left off [2].
*   **Trigger:** This switch occurs when a running process or thread's allocated time slice expires [2, 5].
*   **Role:** This rapid switching is crucial for giving the illusion of simultaneous execution when multiple tasks are running on a single core [3]. In multi-core systems, it is used by the OS scheduler to manage and distribute tasks across different cores [1].


### Multitasking Vs Multi Threading
* Multitasking can be achieved through multithreading where each task is divided into threads that are managed concurrently.

* While multitasking typically refers to the running of multiple applications, multithreading is more granular, dealing with multiple threads within the same application or process.

## II. Java Thread Creation & Life Cycle 🧵

```
In Java, multithreading is the concurrent execution of two or more threads to maximize the utlization of the CPU. Java's multithreading capabilities are part of the java.lang package, making it easy to implement concurrent execution.

A thread is a lightweight process, the smallest unit of processing. Java supports multi-threading through its java.lang.Thread class and the java.lang.Runnable interface.
```

*   **Main Thread:** When a Java program starts, one thread begins running immediately, called the Main Thread, responsible for executing the `main` method.
*   **Creating New Threads in Java:** Developers can create new threads to maximize CPU utilization.
    1.  **Extend `Thread` Class:** Create a class extending `Thread` and override the `run()` method with the desired work. Call the `start()` method on the object to initiate the thread. This approach is mandatory if the class already extends another class (due to Java lacking multiple inheritance).
    2.  **Implement `Runnable` Interface:** Create a class implementing `Runnable` and override the `run()` method. Create a `Thread` instance, pass the `Runnable` object to its constructor, and then call `start()` on the `Thread` object.
*   **Thread States (Life Cycle) 🚦:** A thread progresses through various states during execution.
    *   **New:** The thread object has been created but `start()` has not yet been called.
    *   **Runnable (or Running):** After `start()` is called, the thread is ready to run and waiting for CPU time. Java often treats "Ready to run" and "Executing" as the single `RUNNABLE` state, hence `RUNNING` is not explicitly defined in Java's `Thread.State` enum.
    *   **Blocked / Waiting / Timed Waiting:** The thread is waiting for a resource, another thread to perform an action, or is paused for a specified duration (e.g., using `sleep()`).
    *   **Terminated:** The thread has finished executing.

## III. Core Thread Methods 🛠️

*   **`start()`:** Initiates the new thread, causing its `run()` method to be executed.
*   **`run()`:** Contains the code that constitutes the new thread's execution.
*   **`sleep()`:** Suspends the execution of the current thread for a specified period, typically throwing an `InterruptedException`.
*   **`join()`:** Causes the calling thread (e.g., the Main Thread) to wait for the target thread to finish its execution before proceeding.
*   **`setPriority()`:** Sets the priority of the thread (1 to 10). This serves as a **hint** to the OS/JVM scheduler regarding which thread should receive more execution time.
*   **`interrupt()`:** Sends an interrupt signal to the thread. If the thread is sleeping or waiting, this causes it to wake up and throw an `InterruptedException`.
*   **`yield()`:** Provides a hint to the scheduler that the current thread is willing to give up its current use of the processor, allowing other threads a chance to run.
*   **Daemon Threads:** Background threads (like Java's Garbage Collector) for which the JVM **will not wait** to terminate. If all user threads are finished, the JVM terminates, even if daemon threads are running.

## IV. Synchronization and Locking 🔒

*   **Race Condition:** Occurs when multiple threads access and manipulate a shared resource concurrently, leading to unpredictable or incorrect results because the outcome depends on the relative timing of the threads.
*   **Critical Section:** The part of the program where shared resources are accessed or modified.
*   **Synchronization (`synchronized`):** Used to ensure that only one thread can execute a critical section at a time, preventing race conditions.
    *   Synchronization enforces **Mutual Exclusion**, ensuring simultaneous access to the critical section is prevented.
    *   `synchronized` keywords rely on **Intrinsic Locks** (built-in locks present in every Java object).
*   **Disadvantages of Intrinsic Locks (`synchronized`)**:
    1.  Indefinite Blocking (a thread might wait forever if another thread holds the lock indefinitely).
    2.  Not Interruptible (a waiting thread cannot be easily interrupted).
    3.  No Guarantee of Fairness (no specific order in which waiting threads acquire the lock).
    4.  Cannot Distinguish Read/Write Operations (leading to unnecessary blocking).

### Explicit Locks (Manual Locking)

*   **`Lock` Interface:** Provides more advanced and manual control over locking than the `synchronized` keyword, residing in the `java.util.concurrent.locks` package.
*   **`ReentrantLock`:** A concrete implementation of the `Lock` interface.
    *   **Reentrant Property:** Prevents deadlocks by allowing the same thread that already holds the lock to re-acquire it multiple times (e.g., if one locked method calls another locked method).
    *   **Fairness:** Can be configured to ensure locks are acquired in the order they were requested (First-In, First-Out).
*   **Key Lock Methods:**
    *   **`lock()`:** Acquires the lock; waits indefinitely if the lock is unavailable (similar to `synchronized`).
    *   **`tryLock()`:** Attempts to acquire the lock immediately. If successful, returns `true`; otherwise, returns `false` without waiting.
    *   **`tryLock(time)`:** Waits for a specified amount of time to acquire the lock; if the lock is not available within the timeout, returns `false`.
    *   **`lockInterruptibly()`:** Acquires the lock but allows the waiting thread to be interrupted.
    *   **`unlock()`:** Releases the lock. This should always be placed in a `finally` block to ensure resource release, even if exceptions occur.
*   **`ReadWriteLock`:** Allows multiple threads to read a resource concurrently, but ensures exclusive access for write operations.
    *   It provides separate locks for reading (`readLock`) and writing (`writeLock`).


Below are the advantages and disadvantages associated with using synchronization (intrinsic locks, typically via the `synchronized` keyword) in a Markdown table format:

| Feature | Advantage (Pro) 🟢 | Disadvantage (Con) 🔴 |
| :--- | :--- | :--- |
| **Lock Type & Management** | Uses **Intrinsic Locks** built into every Java object. Locking/unlocking is handled **automatically** by the JVM. | **Lack of Manual Control:** Developers have limited control over *how* and *when* locking and unlocking occur, unlike explicit locks (e.g., `ReentrantLock`). |
| **Mutual Exclusion** | Guarantees **Mutual Exclusion** (only one thread accesses the critical section at a time), which prevents race conditions and data corruption. | **No Read/Write Distinction:** Synchronization locks the entire section without distinguishing between reading and writing, leading to **unnecessary blocking** if multiple threads only need to read a resource. |
| **Reentrancy** | Inherently supports **Reentrancy**, allowing a thread holding a lock to acquire the same lock again without causing a deadlock. | **Non-Interruptible Locking:** A thread blocked while waiting for a synchronized lock **cannot be interrupted** or canceled by another thread. |
| **Waiting Behavior** | Generally **simpler** for basic synchronization needs. | **Indefinite Blocking:** Waiting threads block **indefinitely** (`इन डेफिनेटली`) until the lock is released, as there is no timeout mechanism. |
| **Fairness & Order** | N/A | **No Fairness Guarantee:** Locks are acquired in an **arbitrary manner** (`आर्बिट्रेरी मैनर`), meaning there is **no determined order** for waiting threads. |
| **Starvation Risk** | N/A | Carries a risk of **Starvation**, where certain threads might be continuously overlooked and never receive the lock due to the lack of fairness. |



## V. Deadlock and Resolution 💀

*   **Deadlock:** A situation where two or more threads are permanently blocked, waiting for each other to release resources.
    *   Example: Thread A holds Pen and waits for Paper. Thread B holds Paper and waits for Pen.
*   **Deadlock Conditions (Formal):** Mutual Exclusion, Hold and Wait, No Preemption, and Circular Wait.
*   **Deadlock Resolution:** The most common approach is to enforce a **consistent order** for acquiring locks across all dependent threads.

## VI. Thread Communication (Wait/Notify) 🗣️

*   **Problem without Communication:** Threads continuously check conditions (busy waiting), wasting CPU resources and potentially leading to deadlocks.
*   **Solution:** Java provides methods that can only be called within a `synchronized` context.
    *   **`wait()`:** Causes the current thread to release the lock and wait until another thread calls `notify()` or `notifyAll()`.
    *   **`notify()`:** Wakes up a single thread that is waiting on the same object's lock.
    *   **`notifyAll()`:** Wakes up all threads that are waiting on the same object's lock.
    *   *Usage:* Typically used in producer-consumer scenarios where the producer notifies the consumer when data is ready, and the consumer notifies the producer when the buffer is empty.

This summary is based on the concept of thread safety as discussed in the sources, particularly focusing on what makes code thread safe and the consequences of lacking safety.

## VII. Thread Safety 🛡️

*   **Definition of Thread Safety:** An object or block of code is considered **thread safe** when it provides a guarantee that **unexpected results** will not occur when multiple threads attempt to access it concurrently.
*   **Core Guarantee (Prevention of Corruption):** Thread safety ensures there will be **no race condition** and **no data corruption** (data corruption नहीं हो रहा है) even when multiple threads access the object or code simultaneously.
*   **Achieving Stability:** The goal is to ensure that code remains stable and produces predictable outcomes regardless of the relative timing of concurrent thread execution.
*   **Consequences of Lack of Safety ❌:** If shared data is not kept thread safe, results become **unpredictable** (उल्टे सीधे रिजल्ट आते हैं). Such a scenario, where the outcome depends on the relative timing of threads accessing a shared resource, is known as a **race condition**.
*   **Achieving Thread Safety (Tools) 🛠️:** A major focus of the related topics (like multi-threading basics and locking) is learning how to make things thread safe. Mechanisms explored to ensure thread safety include:
    *   Using the `synchronized` keyword (intrinsic locking).
    *   Employing explicit locks like `ReentrantLock`.
    *   Using specialized locks such as `ReadWriteLock` to distinguish between read and write operations.
    *   Utilizing inter-thread communication methods like `wait` and `notify`.
*   **Pervasive Goal 🎯:** The primary purpose behind studying complex multi-threading mechanisms (like those listed above) is to achieve **thread safety**.

## VIII. Lambda Expressions (Java 8) 💡

*   **Functional Interface:** An interface with exactly one abstract method (e.g., `Runnable` interface).
*   **Lambda Expression:** An anonymous function that can be used to provide a concise implementation for the single abstract method of a Functional Interface.
    *   Syntax: `(parameters) -> { body }`.
    *   Lambda expressions greatly simplify the creation of `Runnable` tasks.

## IX. Executors Framework (Thread Pools) 🏊

### 🚀 I. The Need for Thread Pools and Executors Framework

*   **Definition:** A Thread Pool is a **collection of pre-initialized threads** that are ready to perform tasks. Instead of creating a new thread for every task, tasks are submitted to the pool.
*   **Resource Management:** Creating and destroying a thread for every single task is **computationally expensive** (an "overhead"). Thread pools mitigate this by reusing existing threads.
    *   *Problem prior to Framework:* Manual thread management led to resource issues and poor scalability.
*   **Improved Response Time:** Since threads are already available ("pre-initialized"), tasks can start executing immediately, improving the application's response time.
*   **Control over Thread Count:** Thread pools allow developers to limit the maximum number of active threads, preventing the system from crashing due to excessive thread creation (e.g., thousands of uncontrolled threads).

### 🧩 II. Core Interfaces of the Executors Framework

The Executors Framework consists of three core interfaces:

1.  **`Executor`:** The most basic interface, providing only one method: `execute(Runnable command)`.
    *   It only supports `Runnable` tasks (no return value).
    *   It **lacks shutdown capabilities**.
2.  **`ExecutorService`:** Extends `Executor` and provides enhanced features for managing threads and tasks. This is the interface typically used for standard thread pooling.
    *   Includes methods for managing the lifecycle of the pool, such as `submit()` and `shutdown()`.
3.  **`ScheduledExecutorService`:** Extends `ExecutorService` and adds methods for scheduling tasks to run after a specific delay or periodically.

### 🛠️ III. Creating Thread Pools (`Executors` Utility Class)

The `Executors` class provides utility methods to easily create and configure different types of `ExecutorService` instances:

*   **Fixed Thread Pool (`Executors.newFixedThreadPool(int nThreads)`):**
    *   Creates a pool with a fixed number of worker threads.
    *   Example: `ExecutorService executorService = Executors.newFixedThreadPool(3);`.
    *   If there are more tasks than threads (e.g., 9 tasks and 3 threads), threads are reused to handle multiple tasks sequentially.
*   **Single Thread Executor (`Executors.newSingleThreadExecutor()`):**
    *   Creates a pool guaranteed to execute tasks sequentially using a single worker thread.
*   **Cached Thread Pool (`Executors.newCachedThreadPool()`):**
    *   Creates a dynamic pool that adjusts its size based on load.
    *   Creates new threads as needed for incoming tasks.
    *   Idle threads (inactive for 60 seconds) are terminated and removed from the pool.
    *   *Usage:* Ideal for scenarios where the workload is **variable** and tasks are **short-lived** (e.g., bursty traffic).

### 🎯 IV. Managing Tasks and Results (`submit` and `Future`)

Tasks are submitted to the `ExecutorService` using the `submit()` method.

#### A. Runnable vs. Callable Tasks (The Return Difference)

| Task Type | Purpose | Method Signature | Checked Exceptions | Use Case |
| :--- | :--- | :--- | :--- | :--- |
| **`Runnable`** | For executing tasks that **do not return a result**. | `run(): void` | Must be handled internally with `try-catch`. | Standard background execution. |
| **`Callable<V>`** | For executing tasks that **return a result** (`V`). | `call(): V` | Can be declared in the signature (`throws Exception`). | Tasks requiring computation results. |

#### B. Submitting Tasks

1.  **Submission using `Runnable` (`execute()`):**
    *   The `Executor` interface only supports `execute(Runnable task)`. It returns nothing (`void`).
2.  **Submission using `Runnable` (`submit()`):**
    *   `ExecutorService.submit(Runnable task)`
    *   Even though the task itself returns `void`, the `submit` method returns a `Future<?>` object, which can be used to check task status.
3.  **Submission using `Callable` (`submit()`):**
    *   `ExecutorService.submit(Callable<V> task)`
    *   This returns a `Future<V>` object, where `V` is the return type, allowing the result to be retrieved.
4. **Submission using `Runnable` with `Result` (`submit()`):**
    *   `ExecutorService.submit(Runnable task, V result)`
    * This overload submits a Runnable task for execution and takes an additional parameter: the result (V)
    *  Since Runnable itself does not return a value, the Future.get() method will return the given result (V) upon the task's successful completion. This allows a predefined value or status to be returned even when using a Runnable.


#### C. The `Future` Object 🔮

The `Future` object represents the result of an asynchronous computation.

*   **Retrieving Result:** `V result = future.get();`.
    *   The `get()` method is **blocking**; the calling thread waits until the computation is complete.
*   **Checking Status:**
    *   `future.isDone()`: Returns `true` if the task is completed (either normally, exceptionally, or cancelled).
    *   `future.isCancelled()`: Checks if the task was cancelled.
*   **Waiting with Timeout:** `future.get(long timeout, TimeUnit unit)`.
    *   Waits only for the specified duration. If the result is not available, it throws a `TimeoutException`.
*   **Cancellation:** `future.cancel(boolean mayInterruptIfRunning)`.
    *   If `mayInterruptIfRunning` is `true`, it attempts to interrupt the thread if the task is currently running.

**Code Example (Submission and Retrieval):**
```java
// Using a Single Thread Executor
ExecutorService executor = Executors.newSingleThreadExecutor(); 
// Task returns an Integer (42) using Callable
Future<Integer> future = executor.submit(() -> 42); //

// Blocking call to wait for the result
Integer result = future.get(); //
System.out.println(result); // Prints 42
executor.shutdown(); //
```

### ⏳ V. Executor Service Lifecycle and Shutdown

*   **Orderly Shutdown (`shutdown()`):**
    *   Stops accepting new tasks but **waits** for all previously submitted tasks to complete before terminating the worker threads.
*   **Immediate Shutdown (`shutdownNow()`):**
    *   Attempts to stop all actively executing tasks immediately and halts the processing of waiting tasks.
    *   *Note:* Using `shutdownNow()` may result in tasks not running at all.
*   **Waiting for Termination (`awaitTermination()`):**
    *   Used by the main thread to wait for the `ExecutorService` to shut down completely (tasks finished).
    *   Example: `executor.awaitTermination(100, TimeUnit.SECONDS)`.
*   **Status Checks:**
    *   `isShutdown()`: Returns `true` immediately after `shutdown()` or `shutdownNow()` is called.
    *   `isTerminated()`: Returns `true` only if `isShutdown()` is true AND all tasks have completed execution.

### ✨ VI. Advanced Task Execution 🏃‍♂️

The `ExecutorService` offers sophisticated methods for handling collections of `Callable` tasks, primarily using the `invokeAll` and `invokeAny` methods, both of which are **blocking calls**.

#### 1. `invokeAll` Methods (Waiting for All Tasks)

The `invokeAll` method executes a collection of tasks and waits until all of them are complete.

*   **`invokeAll(Collection<? extends Callable<T>> tasks)`**
    *   **Description:** Executes all the given tasks.
    *   **Blocking Behavior:** The calling thread **blocks indefinitely** until *all* tasks have completed execution.
    *   **Return Value:** Returns a `List<Future<T>>`, where each `Future` object holds the result or status for the corresponding submitted task.
    *   **Completion Status:** The `Future.isDone()` method will be `true` for every element in the returned list, as the call only returns once all tasks are completed.

*   **`invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)`**
    *   **Description:** Executes the given tasks but imposes a time limit on their overall execution.
    *   **Blocking Behavior:** The calling thread blocks until either all tasks are completed, or the specified `timeout` expires.
    *   **Cancellation:** If the timeout expires before all tasks are completed, the method returns, and **all unfinished tasks are immediately cancelled**.
    *   **Return Value:** Returns a `List<Future<T>>`. For tasks that were cancelled due to timeout, their corresponding `Future` objects will indicate cancellation.

#### 2. `invokeAny` Methods (Waiting for the First Task)

The `invokeAny` method executes a collection of tasks but returns the result of the first task that finishes, stopping further execution of others.

*   **`invokeAny(Collection<? extends Callable<T>> tasks)`**
    *   **Description:** Executes the given tasks and returns the result of the first task to successfully complete its execution.
    *   **Blocking Behavior:** This is a **blocking call**. The calling thread waits until one of the tasks completes.
    *   **Cancellation:** Upon successful completion of the fastest task, the results are returned directly (not wrapped in a `Future`), and **all other remaining unfinished tasks are cancelled**.

*   **`invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)`**
    *   **Description:** Executes the given tasks, waiting only for a specified `timeout` for a task to complete.
    *   **Blocking Behavior:** The calling thread waits for the completion of the fastest task, up to the defined timeout.
    *   **Timeout Handling:** If no task completes successfully within the specified time, a `TimeoutException` will be thrown.
    *   **Return Value:** Returns the result of the first task to finish successfully.

The following section provides updated notes for the Scheduled Executor Service, including separate code examples for all methods discussed, fulfilling your request for Markdown format and clear separation.

---

### ⏰ VII. Scheduled Executor Service 🕰️

The `ScheduledExecutorService` is used for delayed or repetitive task execution.

*   **Return Type Differentiation:** The scheduling methods of `ScheduledExecutorService` return a specialized type called **`ScheduledFuture`**. This differs from the standard `ExecutorService` methods (like `submit()`), which return a regular **`Future`** object. The `ScheduledFuture` allows for task management like cancellation, but is tailored for time-based execution.
*   **Creating a Scheduled Pool:**
    *   Example: `ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();`.

1.  **Delayed Execution (One-time):**
    *   `schedule(Runnable/Callable, long delay, TimeUnit unit)`: Executes the task once after the initial delay.

2.  **Periodic Execution (Fixed Rate):**
    *   `scheduleAtFixedRate(Runnable, long initialDelay, long period, TimeUnit unit)`.
    *   Tasks run at fixed periodic intervals, calculated from the **start time** of the previous task.
    *   **Crucial Point:** The period is measured regardless of how long the task takes. If the task takes longer than the period, subsequent tasks will overlap or queue up immediately, meaning there is **no guaranteed gap** between the end of one task and the start of the next.

3.  **Periodic Execution (Fixed Delay):**
    *   `scheduleWithFixedDelay(Runnable, long initialDelay, long delay, TimeUnit unit)`.
    *   The delay period begins **after** the previous task finishes execution.
    *   **Crucial Point:** This ensures there is always a fixed delay *between* the completion of one task and the start of the next (no overlapping).

---


### 📝 Scheduled Executor Service Code Examples

```java
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledFuture;

// Initialize the scheduler (using a single thread pool is common for scheduled tasks)
ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

// --- 1. schedule(Runnable, delay, unit): One-time delayed task (Source) ---

// Defining the task simply using a lambda expression
Runnable delayedTask = () -> {
    System.out.println("Task 1: Executed after 3 seconds. ⏳");
};

// Schedule the task and retrieve the ScheduledFuture
ScheduledFuture<?> future = scheduler.schedule(delayedTask, 3, TimeUnit.SECONDS);

try {
    // Wait on the future result (optional, but ensures main thread waits)
    future.get();
    
} catch (Exception e) {
    Thread.currentThread().interrupt();
}
// Note: We won't shut down here yet, as we want to reuse the 'scheduler' for the next examples.
```

```java
// --- 2. scheduleAtFixedRate: Periodic execution (Fixed Interval) (Source) ---

// Define a runnable task using lambda
// Note: To prevent infinite execution, we must include internal logic to stop the scheduler.
final int MAX_RATE_RUNS = 3;
final int[] rateCount = {0}; // Use an array or AtomicInteger to simulate non-final modification in lambda

Runnable fixedRateTask = () -> {
    rateCount++;
    System.out.printf("Task 2 (Rate): Run %d. Time: %s%n", rateCount, System.currentTimeMillis() % 10000);
    
    if (rateCount >= MAX_RATE_RUNS) {
        // Stop the scheduler after hitting the limit
        System.out.println("Task 2: Fixed Rate execution stopped. 🛑");
        // Use shutdownNow() to terminate recurring tasks immediately
        scheduler.shutdownNow(); 
    }
};

// Initial delay: 1s, Period: 1s (Execution attempts to start every 1 second)
scheduler.scheduleAtFixedRate(fixedRateTask, 1, 1, TimeUnit.SECONDS);

try {
    // Wait for the scheduler to fully terminate
    scheduler.awaitTermination(5, TimeUnit.SECONDS); 
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
```

```java
// --- 3. scheduleWithFixedDelay: Periodic execution (Fixed Gap) (Source) ---

// Re-initialize scheduler since the previous example shut it down
ScheduledExecutorService schedulerFixedDelay = Executors.newSingleThreadScheduledExecutor(); 

final int MAX_DELAY_RUNS = 3;
final int[] delayCount = {0}; 

Runnable fixedDelayTask = () -> {
    delayCount++;
    System.out.printf("Task 3 (Delay): Run %d. Starting execution. %n", delayCount);
    
    // Simulate a long task (e.g., 1.5 seconds)
    try {
        Thread.sleep(1500); 
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
    
    if (delayCount >= MAX_DELAY_RUNS) {
        System.out.println("Task 3: Fixed Delay execution stopped. ⚙️");
        schedulerFixedDelay.shutdownNow();
    }
};

// Initial delay: 1s, Delay between tasks: 1s (The 1s delay starts only AFTER the 1.5s task finishes)
schedulerFixedDelay.scheduleWithFixedDelay(fixedDelayTask, 1, 1, TimeUnit.SECONDS);

try {
    // Wait for the scheduler to fully terminate
    schedulerFixedDelay.awaitTermination(8, TimeUnit.SECONDS); 
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
```

### 🔄 VIII. Thread Synchronization and Communication (Relevant to Task Execution)

While not strictly part of the framework interfaces, synchronization tools are necessary when tasks submitted to the pool share resources.

*   **CountDownLatch 🔐:**
    *   Used to **wait for one or more threads to complete** their tasks before a waiting thread (often the main thread) proceeds.
    *   Initialized with a count (`N`). Each dependent service/task calls `latch.countDown()` upon completion.
    *   The waiting thread calls `latch.await()`, which blocks until the count reaches zero.
    *   *Limitation:* **Not reusable**; once the count reaches zero, it cannot be reset.
*   **CyclicBarrier 🛑:**
    *   Allows a set of threads to wait for each other to reach a common barrier point.
    *   When the last thread reaches the barrier, all waiting threads are released simultaneously.
    *   *Advantage:* **Reusable**; the barrier can be reset.
    *   It can optionally execute a `BarrierAction` when the last thread arrives.
*   **CompletableFuture (CF) 🚀 (Java 8):**
    *   Introduced to handle asynchronous programming and chain tasks efficiently.
    *   CF allows tasks to be run asynchronously (e.g., using `supplyAsync()`) without blocking the main thread.
    *   Provides non-blocking composition methods like `thenApply()` (process the result of a previous stage).
    *   The CF uses the default `Executor` for execution but allows a custom `Executor` to be provided, granting control over thread management.
    *   CF can handle waiting using `get()` (blocking, checked exception) or `join()` (blocking, unchecked exception).

---

### 📝 IX. Code Examples (Functionality)

**1. Using `Callable` and `Future`:**
```java
// Submitting a Callable task
ExecutorService executor = Executors.newSingleThreadExecutor();
Future<String> future = executor.submit(() -> {
    Thread.sleep(2000); //
    return "Task Result"; //
});
String result = future.get(); // Main thread waits here
executor.shutdown();
```

**2. CountDownLatch (Waiting for completion):**

**With Callable -**

```java
public class Main {
    public static void main(String[] args) {
        int numberOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        CountDownLatch latch = new CountDownLatch(numberOfServices);
        
        // Submit tasks, ensuring each calls latch.countDown()
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        // ...

        latch.await(); // Main thread blocks until the count reaches zero

        System.out.println("All services finished."); //
        executorService.shutdown();
    }
}

class DependentService implements Callable<String> {
    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " service started.");
            Thread.sleep(2000);
        } finally {
            latch.countDown();
        }

        return "ok";
    }
}
```

**With Runnable -**

```java
public class Main {
    public static void main(String[] args) {

        int numberOfServices = 3;
        CountDownLatch latch = new CountDownLatch(numberOfServices);
        
        // Submit tasks, ensuring each calls latch.countDown()
        for (int i = 0; i < numberOfServices; i++) {
            new Thread(new DependentService(latch)).start();
        }

        latch.await(); // Main thread blocks until the count reaches zero

        System.out.println("All services finished."); //
        
    }
}

class DependentService implements Runnable {

    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " service started.");
            Thread.sleep(2000);
        } catch(Exception e)  {

        } finally {
            latch.countDown();
        }
    }
}
```
**3. CyclicBarrier (`Allows a set of threads to wait for each other to reach a common barrier point. When the last thread reaches the barrier, all waiting threads are released simultaneously`):**

```java
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        
        int numberOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        CyclicBarrier barrier = new CyclicBarrier(numberOfServices);
        
        // Submit tasks, ensuring each calls latch.countDown()
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        // ...

        System.out.println("All services finished."); //
        executorService.shutdown();
    }
}

class DependentService implements Callable<String> {
    private final CyclicBarrier barrier;

    public DependentService(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started.");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " is waiting at the barrier.");
        barrier.await();

        return "ok";
    }
}
```
**CyclicBarrier Real World Example -**
```java
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        
        int numberOfSubsystems = 4;
        CyclicBarrier barrier = new CyclicBarrier(numberOfServices, new Runnable() {
            @Override
            public void run() {
                System.out.println("All subsystems are up and running. System startup complete.");
            }
        });
        
        Thread webServerThread = new Thread(new Subsystem("Web Server", 2000, barrier));
        Thread databaseThread = new Thread(new Subsystem("Database", 4000, barrier));
        Thread cacheThread = new Thread(new Subsystem("Cache", 3000, barrier));
        Thread messagingServiceThread = new Thread(new Subsystem("Messaging Service", 3500, barrier));

        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingServiceThread.start();

        // ...

        System.out.println("All services finished."); //
        executorService.shutdown();
    }
}

class Subsystem implements Runnable {
    private String name;
    private int initializationTime;
    private CyclicBarrier barrier;

    public Subsystem(String name, int initializationTime, CyclicBarrier barrier) {
        this.name = name;
        this.initializationTime = initializationTime;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "initialization started");
            Thread.sleep(initializationTime); // simulate time taken to initialize
            System.out.println(name + " initialization complete");
            barrier.await();
        } catch (InterruptedException e | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
```

## X. Advanced Concurrency Utilities ⚙️

*   **`CountDownLatch`:** Used to cause one or more threads to wait for the completion of a set number of operations or threads.
    *   The latch is initialized with a count. Worker threads call `countDown()` when they finish. The main thread calls `await()` and waits until the count reaches zero.
    *   *Limitation:* Not reusable; once the count reaches zero, it cannot be reset.
*   **`CyclicBarrier`:** Used to wait for multiple threads to reach a specific common point (a barrier) before they can proceed.
    *   Threads call `await()` when they reach the barrier. The threads are released only when the last thread reaches the barrier.
    *   *Advantage:* The barrier is reusable (cyclic) via the `reset()` method.

## XI. CompletableFuture (Java 8+) 🎯

*   **Purpose:** Introduced in Java 8 to handle asynchronous programming (non-blocking execution) more efficiently and allows for chaining dependent actions.
*   **Creation:** Use static methods like `CompletableFuture.supplyAsync(Supplier)` to run tasks asynchronously.
*   **Result Handling:**
    *   **`get()` and `join()`:** Used to retrieve the result, forcing the main thread to wait for completion (blocking). (`join()` is unchecked, unlike `get()`).
    *   **Chaining:** Allows processing the result of one task using methods like `thenApply()` (e.g., performing a calculation on the previous result).
    *   **Waiting for Multiple Tasks:** Methods like `CompletableFuture.allOf(f1, f2, ...)` create a new `CompletableFuture` that completes only when all specified futures are finished.
    *   **Timeout Handling:** Can apply timeouts using methods like `orTimeout()` or custom handling with `exceptionally()`.

***
*Note: The speaker guarantees that this video covers everything necessary for a Java developer, including production-level code and interview topics, stating that learning multithreading is crucial for professional confidence and experience.*