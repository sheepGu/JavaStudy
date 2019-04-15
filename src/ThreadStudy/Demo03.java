package ThreadStudy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @Classname Demo03
 * @Description TODO
 * @Date 2019/3/24 17:36
 * @Created by gumei
 * @Author: lepua
 */
public class Demo03 {
    public static int count = 0;

    public static int getCount(){
        return count;

    }
    //传统实现
//    public synchronized static void addCount(){
//        count++;
//    }
    //读写锁的方式实现
    public  static void addCount(){
        Lock writeLock=Demo04.INSTANCE.writeLock();
        writeLock.lock();
        count++;
        writeLock.unlock();
    }


    public static void main(String[] args) {
        ExecutorService executorService=new ThreadPoolExecutor(10,1000,60L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
        for (int i=0;i<1000;i++){
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    Demo03.addCount();
                }

            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
        System.out.println(Demo03.count);
    }
}
