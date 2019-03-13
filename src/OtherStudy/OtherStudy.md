## SP1

1. 主要内容

   try-catch-resource实现

2. 内容
  为了能够配合try-with-resource，资源必须实现AutoClosable接口。该接口的实现类需要重写close方法：

  ```
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
  
  ```

  ```
  package OtherStudy.sp1;
  
  public class TryWithResource {
      public static void main(String[] args) {
          try(Connection conn=new Connection()) {
              conn.sendData();
          }catch (Exception e){
              e.printStackTrace();
          }
      }
  }
  
  ```

  


