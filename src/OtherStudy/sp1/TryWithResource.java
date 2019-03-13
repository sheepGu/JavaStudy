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
