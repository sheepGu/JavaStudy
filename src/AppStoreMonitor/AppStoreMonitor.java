package AppStoreMonitor;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.net.MalformedURLException;
import java.util.Date;

/**
 * @Classname AppStoreMonitor
 * @Description TODO
 * @Date 2019/4/14 11:38
 * @Created by gumei
 * @Author: lepua
 */
public class AppStoreMonitor {
    public static void main(String[] args) throws IOException, InterruptedException, JavaLayerException {
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int count=1;
                    while(true){
                        new AppStoreMonitor().getHtml();
                        System.out.println("执行的第"+count+"次");
                        count++;
                        Thread.sleep(10000);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
//        AppStoreMonitor.playMusic();

    }



    public  void getHtml() throws IOException {
        Document doc = Jsoup.connect("https://www.apple.com/cn/shop/refurbished/mac/macbook-air-macbook-pro-16gb").get();
        Elements products = doc.select("div .refurbished-category-grid-no-js");
        System.out.println("获取products的值"+products.size());
        Elements s=products.select("li");
        System.out.println("获取商品展示页面中li个数"+s.size());
        String xhtml;
        for(int i=0;i<s.size();i++){
            xhtml=s.get(i).toString();
            if(xhtml.indexOf("翻新 13.3 英寸 MacBook Pro")>0&&xhtml.indexOf("四核")>0){ String url= s.get(i).select("a").attr("href");

                String name= s.get(i).select("a").text();
                String price= s.get(i).select("div").text();
                System.out.println(new Date()+"标题为："+name+"价格为："+price+"链接为："+url);
            }

        }
    }

    public static void playMusic() throws JavaLayerException, FileNotFoundException, MalformedURLException {
        File file=new File("C:\\Users\\gumei\\Downloads\\cnwav.wav");
//        FileInputStream fis=new FileInputStream(file);
//        BufferedInputStream stream=new BufferedInputStream(fis);
//        Player player=new Player(stream);
//        player.play();
            AudioClip sound_choose= Applet.newAudioClip(file.toURL());
            sound_choose.play();//播放

    }
}
