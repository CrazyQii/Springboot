# 高并发与多线程（五）AQS详解

[参考文章](https://github.com/h2pl/Java-Tutorial/blob/master/docs/java/currency/Java%E5%B9%B6%E5%8F%91%E6%8C%87%E5%8D%977%EF%BC%9AJUC%E7%9A%84%E6%A0%B8%E5%BF%83%E7%B1%BBAQS%E8%AF%A6%E8%A7%A3.md)

## 一、介绍

AbstractQueuedSynchronizer（以下简写AQS）这个抽象类，因为它是 Java 并发包的基础工具类，是实现 ReentrantLock、CountDownLatch、Semaphore、FutureTask 等类的基础

AQS结构

```java
// 头结点，你直接把它当做 当前持有锁的线程 可能是最好理解的
private transient volatile Node head;

// 阻塞的尾节点，每个新的节点进来，都插入到最后，也就形成了一个链表
private transient volatile Node tail;

// 这个是最重要的，代表当前锁的状态，0代表没有被占用，大于 0 代表有线程持有当前锁
// 这个值可以大于 1，是因为锁可以重入，每次重入都加上 1
private volatile int state;

// 代表当前持有独占锁的线程，举个最重要的使用例子，因为锁可以重入
// reentrantLock.lock()可以嵌套调用多次，所以每次用这个来判断当前线程是否已经拥有了锁
// if (currentThread == getExclusiveOwnerThread()) {state++}
private transient Thread exclusiveOwnerThread; //继承自AbstractOwnableSynchronizer
```

等待队列中，会将每一个线程封装成Node，数据结构是链表

```java
     +------+  prev +-----+       +-----+
head |      | <---- |     | <---- |     |  tail
     +------+       +-----+       +-----+
```

## 二、线程枪锁

源码分析

`ReentrantLock` 在内部用了内部类 `Sync` 来管理锁，所以真正的获取锁和释放锁是由 `Sync` 的实现类来控制的。

Sync 有两个实现，分别为 `NonfairSync`（非公平锁）和 `FairSync`（公平锁）

**公平锁：** 多个线程按照申请锁的顺序去获得锁，线程会直接进入队列去排队，永远都是队列的第一位才能得到锁。

 - 优点：所有的线程都能得到资源，不会饿死在队列中。
 - 缺点：吞吐量会下降很多，队列里面除了第一个线程，其他的线程都会阻塞，cpu唤醒阻塞线程的开销会很大。 

**非公平锁：** 多个线程去获取锁的时候，会直接去尝试获取，获取不到，再去进入等待队列，如果能获取到，就直接获取到锁。

 - 优点：可以减少CPU唤醒线程的开销，整体的吞吐效率会高点，CPU也不必取唤醒所有线程，会减少唤起线程的数量。
 - 缺点：你们可能也发现了，这样可能导致队列中间的线程一直获取不到锁或者长时间获取不到锁，导致饿死。

## 三、线程解锁

源码分析

## 四、总结

1. 锁状态。我们要知道锁是不是被别的线程占有了，**这个就是 state 的作用**，它为 0 的时候代表没有线程占有锁，可以去争抢这个锁，用 CAS 将 state 设为 1，如果 CAS 成功，说明抢到了锁，这样其他线程就抢不到了，如果锁重入的话，state进行 +1 就可以，解锁就是减 1，直到 state 又变为 0，代表释放锁，所以 lock() 和 unlock() 必须要配对啊。然后唤醒等待队列中的第一个线程，让其来占有锁。
2. 线程的阻塞和解除阻塞。AQS 中采用了 `LockSupport.park(thread)` 来挂起线程，用 `unpark` 来唤醒线程。
3. 阻塞队列。因为争抢锁的线程可能很多，但是只能有一个线程拿到锁，其他的线程都必须等待，这个时候就需要一个 queue 来管理这些线程，AQS 用的是一个 FIFO 的队列，就是一个链表，每个 node 都持有后继节点的引用。