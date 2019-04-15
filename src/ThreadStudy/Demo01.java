package ThreadStudy;

/**
 * @Classname demo01
 * @Description TODO
 * @Date 2019/3/24 12:53
 * @Created by gumei
 * @Author: lepua
 */
public class Demo01 {

    public static void main(String[] args) {
        for (int i =0;i<10;i++){
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("我是"+Thread.currentThread().getName());
                }
            });
            t.start();
        }
    }
}
