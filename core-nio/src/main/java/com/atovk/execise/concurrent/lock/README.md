# JAVA LOCK 大全

\[TOC\]

## 一、广义分类：乐观锁/悲观锁

### 1.1 乐观锁的实现CAS (Compare and Swap)

**乐观锁适合低并发的情况，在高并发的情况下由于自旋，性能甚至可能悲观锁更差。**

CAS是一种算法，`CAS(V,E,N)`,V：要更新的变量 E：预期值 N：新值。

*   如果多个线程进行CAS操作，只有一个会成功，其余的会失败（允许再次尝试）。
*   CAS是乐观锁的一种带自选的实现算法（对象和类的关系）。
*   操作系统保证CAS的执行是CPU原子指令。

### 1.2 sun.misc.Unsafe

Java中CAS操作的执行依赖于sun.misc.Unsafe类的方法，Unsafe中的方法都是native的。

*   (Unsafe类，非线程安全，拥有类似C的指针操作，Java官方不建议直接使用的Unsafe类)

```java
    //Usafe的几个CAS方法
    public final native boolean compareAndSwapObject(Object var1, long var2, Object var4, Object var5);
    public final native boolean compareAndSwapInt(Object var1, long var2, int var4, int var5);
    public final native boolean compareAndSwapLong(Object var1, long var2, long var4, long var6);

```

### 1.3 java.util.concurrent.atomic

并发包中的原子操作类(java.util.concurrent.atomic)，在该包中提供了许多基于CAS实现的原子操作类。
这些方法都是基于调用Unsafe类实现的。

### 1.4 CAS的ABA问题 AtomicStampedReference&AtomicMarkableReference

1.  ABA问题是反复读写问题，在多个线程并行时，一个线程把1改成2，另一个线程又把2改成1的情况。

2.  CSA的ABA问题可以使用 AtomicStampedReference&AtomicMarkableReference两个类来避免。

3.  AtomicStampedReference 是一个带有时间戳的对象引用。在每次修改后不仅会设置新值，还会记录更改的时间。当该类设置对象时必须同时满足时间戳和期望值才能写入成功。避免了反复读写问题。

4.  AtomicMarkableReference 是使用了一个bool值来标记修改，原理与AtomicStampedReference类似，不能避免ABA问题，可以减少发生概率。

### 1.5 悲观锁（读写锁是悲观锁的两种实现）

#### 1.5.1 ReentrantReadWriteLock 可重入读写锁

ReentrantReadWriteLock的构造函数接受一个bool fair 用来指定是否是`fair公平锁`。默认是`unfair`.

```
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

```

使用读写锁的时候,主动加锁（lock)，一般在finally中释放锁（unlock）。

#### 1.5.2 Synchronized

经过不断的优化（详见 三、JAVA Synchronized 锁的三种级别），在低并发情况下性能很好。

## 二、Java锁的两种实现：ReentrantLock 与 Synchronized

可重入锁ReentrantLock 类实现了 Lock ，它拥有与 synchronized 相同的并发性和内存语义。
添加了类似锁投票、定时锁等候和可中断锁等候的一些特性。

此外，它还提供了在激烈争用情况下更佳的性能
(当许多线程都想访问共享资源时，JVM 可以花更少的时候来调度线程，把更多时间用在执行线程上)

它有一个与锁相关的获取计数器，如果拥有锁的某个线程再次得到锁，那么获取计数器就加1，然后锁需要被释放两次才能获得真正释放。
这模仿了 synchronized 的语义:如果线程进入由线程已经拥有的监控器保护的 synchronized 块，就允许线程继续进行，当线程退出第二个（或者后续） synchronized 块的时候，不释放锁，只有线程退出它进入的监控器保护的第一个 synchronized 块时，才释放锁。

[IBM技术论坛中介绍 synchronized 和ReentrantLock的文章。（Jdk5）](https://links.jianshu.com/go?to=https%3A%2F%2Fwww.ibm.com%2Fdeveloperworks%2Fcn%2Fjava%2Fj-jtp10264%2Findex.html)
文章的主要论述：synchronized 的功能集是 ReentrantLock 的子集。
ReentrantLock 多了：时间锁等候、可中断锁等候、无块结构锁、多个条件变量或者锁投票等特性。
所以 ReentrantLock 从功能上来说完全可以取代 synchronized。但是实际使用中不用这么绝对。
synchronized只有一个好处，使用方便简单，不用主动释放锁。

文章写于jdk5时期，jdk6给synchronized引入了偏向锁等优化。性能差距越来越小。
所以除非用到ReentrantLock的独有特性。其他情况下也可以继续使用Synchronized.

## 三、synchronized 性能优化：Synchronized的三种级别

无锁、偏向、轻量、重量几种级别的转换图如下：

![](https://upload-images.jianshu.io/upload_images/10341818-7f5175034e9f2442.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1000/format/webp)

sync锁级别转化.png

### 3.1 Biased Locking 偏向锁(轻量级锁的多线程优化技术jdk6引入)

是Java6引入的一项针对轻量级锁的多线程优化技术。

> *   偏向锁，顾名思义，它会偏向于第一个访问锁的线程，如果在运行过程中，同步锁只有一个线程访问，不存在多线程争用的情况，则线程是不需要触发同步的，这种情况下，就会给线程加一个偏向锁。
> *   如果在运行过程中，遇到了其他线程抢占锁，则持有偏向锁的线程会被挂起，JVM会消除它身上的偏向锁，将锁恢复到标准的轻量级锁。

*   它通过消除资源无竞争情况下的同步原语，进一步提高了程序的运行性能。但当程序有大量竞争情况，应该关闭该特性。

```
//开启偏向锁
-XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
//关闭偏向锁
-XX:-UseBiasedLocking

```

### 3.2 轻量级锁

由偏向锁升级，当第二个线程加入锁竞争的时候，偏向锁就升级为轻量级锁。
加锁过程：

1.  markWord锁标志位为无锁状态`01`时，在当前线程的栈帧中创建一个Lock Record 用来拷贝目前对象的markWord。
2.  拷贝成功后，JVM使用CAS尝试将对象的markWord指向Lock Record。如果成功执行3，失败执行4。
3.  成功更新了markWord的指针后，该线程就有了该对象的锁，会将markWord中的锁标志为设为`00`:轻量锁。
4.  更新失败了，则先检查对象的markWord是否指向该线程的栈帧（Stack里的）。如果是则其实已经获取锁了，如果不是则说明多线程竞争，则锁膨胀为重量级锁定`10`。

markWord存储内容（最后2bit是锁状态在无锁和偏向锁两种状态下，2bit前的1bit标识是否偏向）

| 状态 | 锁标志位(2bit) | markWord存储内容 |
| --- | --- | --- |
| 未锁定 | 01 | 对象哈希码、对象分代年龄 |
| 轻量级锁定 | 00 | 指向锁记录的指针 |
| 膨胀(重量级锁定) | 10 | 执行重量级锁定的指针 |
| GC标记 | 11 | 空(不需要记录信息) |
| 可偏向 | 01 | 偏向线程ID、偏向时间戳、对象分代年龄 |

具体的存储内容如下：

![](https://upload-images.jianshu.io/upload_images/10341818-67bc9bee5e56829b.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/693/format/webp)

markWord\_lock.jpg

### 3.3 重量级锁

重量级锁发生在轻量锁释放锁的期间，之前在获取锁的时候它拷贝了锁对象头的markWord，在释放锁的时候如果它发现在它持有锁的期间有其他线程来尝试获取锁了，并且该线程对markWord做了修改，两者比对发现不一致，则切换到重量锁。

## 四、其他锁：阻塞BlockingLock/自旋锁SpinLock/公平fairLock /unfairLock/闭锁Latch

### 4.1 阻塞锁 Blocking lock

阻塞锁会有线程切换的代价，但是阻塞锁阻塞后不占用CPU。
阻塞锁一般是悲观锁。

### 4.2 自旋锁 Spin lock

*   自旋锁原理非常简单，如果持有锁的线程能在很短时间内释放锁资源，那么那些等待竞争锁的线程就不需要做内核态和用户态之间的切换进入阻塞挂起状态，它们只需要等一等（自旋），等持有锁的线程释放锁后即可立即获取锁，这样就避免用户线程和内核的切换的消耗。
*   性能原因，一般JVM会限制自旋等待时间。
    自旋锁一般是乐观锁。

#### 4.2.1 自旋锁优缺点

*   优点：在锁竞争不激烈的情况下，占用锁的时间非常短的代码来说，自旋操作(cpu空转)的消耗小于线程阻塞挂起的消耗。
*   缺点：如果锁竞争激烈，或者持有锁的线程需要长时间占用锁执行同步块，就不适合自旋锁，这是CPU空转的消耗大于线程阻塞的消耗。

Java线程切换的代价:
Java的线程是映射到操作系统线程上的，如果要阻塞或唤醒一个线程就需要操作系统介入，需要在用户态与和心态之间切换。

> *   内核态: CPU可以访问内存所有数据, 包括外围设备, 例如硬盘, 网卡. CPU也可以将自己从一个程序切换到另一个程序
> *   用户态: 只能受限的访问内存, 且不允许访问外围设备. 占用CPU的能力被剥夺, CPU资源可以被其他程序获取

jdk1.6默认开启自旋锁，从JVM的层面对显示锁(都是悲观锁)做优化，"智能"的决定自旋次数。
而乐观锁通过CAS实现，非阻塞，失败后继续获取还是放弃的实现不确定，只能程序员从代码层面对乐观锁做自旋(我称之为自旋乐观锁)。

### 4.3 fair/unfair

公平锁，非公平锁。
公平锁维护了一个队列。要获取锁的线程来了都排队。后续的线程按照队列顺序来获取锁。
非公平锁没有维护队列的开销，没有上下文切换的开销，可能导致不公平，但是性能比fair好很多。

ReentrantLock的带参构造函数`ReentrantLock(boolean fair)`可以指定实现公平还是非公平锁。默认是非公平锁。

### 4.4 闭锁 Latch

闭锁（Latch）是一种同步工具类，可以延迟线程的进度直到其到达终止状态。
闭锁的作用相当于一扇门：在闭锁到达结束状态之前，这扇门一直是关闭的，并且没有任何线程能通过，当到达结束状态时，这扇门会打开并允许所有的线程通过。

Java中CountDownLatch是一种闭锁实现，位于concurrent包下。

### 4.5 锁消除

锁消除指的是在JVM即使编译时，通过运行少下文的扫描，去除不可能存在共享资源竞争的锁。
通过锁消除，可以节省毫无意义的锁请求.

比如在单线程下使用StringBuffer,其中的同步完全没有必要，这时候JVM可以在运行时基于逃逸分析计数，消除不必要的锁。

## 五、如何避免死锁

死锁是类似这样的情况：a,b两个线程，a持有锁A 等待锁B;b持有锁B等待锁A。a,b相互等待，谁也执行不下去。
避免死锁的原则是

1.  避免持有多个锁。
2.  如果确实需要多个锁，所有代码都应该按照相同的顺序去申请锁。