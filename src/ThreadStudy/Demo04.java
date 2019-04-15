package ThreadStudy;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Classname Demo04
 * @Description 读写锁
 * @Date 2019/3/25 0:56
 * @Created by gumei
 * @Author: lepua
 * 读写锁。分为读锁和写锁，多个读锁不互斥，读锁与写锁互斥，由Java虚拟机控制。如果代码允许很多线程同时读，但不能同时写，就上读锁；如果代码不允许同时读，并且只能有一个线程在写，就上写锁。
 * 读写锁的接口是ReadWriteLock，具体实现类是 ReentrantReadWriteLock。synchronized属于互斥锁，任何时候只允许一个线程的读写操作，其他线程必须等待；而ReadWriteLock允许多个线程获得读锁，但只允许一个线程获得写锁，效率相对较高一些。
 *
 */
public enum Demo04 {
    INSTANCE;

    private static final ReadWriteLock lock=new ReentrantReadWriteLock();

    @NotNull
    public Lock writeLock(){
        return lock.writeLock();
    }

}
