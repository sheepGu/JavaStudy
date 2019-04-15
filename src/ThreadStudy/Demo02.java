package ThreadStudy;

import java.util.concurrent.*;

/**
 * @Classname Demo02
 * @Description TODO
 * @Date 2019/3/24 17:16
 * @Created by gumei
 * @Author: lepua
 */
public class Demo02 {
    public static void main(String[] args) throws InterruptedException {
        //ExecutorService executorService= Executors.newCachedThreadPool();
        ExecutorService executorService=new ThreadPoolExecutor(5,5,60L, TimeUnit.SECONDS,new ArrayBlockingQueue(10));
        for(int i=0;i<10;i++){
            Runnable r=new Runnable() {
                @Override
                public void run() {
                    System.out.println("我叫"+Thread.currentThread().getName());
                }
            };
            executorService.execute(r);
        }
        executorService.awaitTermination(60L,TimeUnit.SECONDS);
        executorService.shutdown();

    }
}
