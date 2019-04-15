import java.applet.AudioClip;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import java.io.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
public class MusicPlayer extends JDialog implements Runnable,ItemListener,ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Thread thread;
    JComboBox<Serializable> choiceMusic;
    AudioClip clip;
    JButton buttonPlay,buttonLoop,buttonStop;
    String str;
    MusicPlayer(){
        thread=new Thread(this);
        choiceMusic=new JComboBox();
        choiceMusic.addItem("src/1.wav");
        choiceMusic.addItem("‪2.wav");
        choiceMusic.addItem("3.wav");
        choiceMusic.addItemListener(this);
        buttonPlay=new JButton("播放");
        buttonLoop=new JButton("循环");
        buttonStop=new JButton("停止");
        buttonPlay.addActionListener(this);
        buttonLoop.addActionListener(this);
        buttonStop.addActionListener(this);
        setLayout(new FlowLayout());
        add(choiceMusic);
        add(buttonPlay);
        add(buttonLoop);
        add(buttonStop);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350,80);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonPlay) {
            clip.play();
        } else if(e.getSource()==buttonLoop) {
            clip.loop();
        } else if(e.getSource()==buttonStop) {
            clip.stop();
        }
    }
    @Override
    public void itemStateChanged(ItemEvent arg0) {
        str=choiceMusic.getSelectedItem().toString();
        if(!(thread.isAlive())){
            thread=new Thread(this);
        }
        try{thread.start();
        }
        catch(Exception ee){}
    }
    @Override
    public void run() {
        try {
            File file=new File("C:\\Users\\gumei\\Downloads\\cnwav.wav");
            URI uri=file.toURI();
            URL url=uri.toURL();
            clip=Applet.newAudioClip(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        MusicPlayer musicplayer=new MusicPlayer();
        musicplayer.run();
        musicplayer.thread.start();
    }
}