package OtherStudy.sp1;

/**
 * 集成自动关闭的接口类，实现close的方法
 */
public class Connection implements AutoCloseable {


    public void sendData(){
        System.out.println("正在发送数据");
    }
    @Override
    public void close() throws Exception {
        System.out.println("正在关闭");
    }

}
