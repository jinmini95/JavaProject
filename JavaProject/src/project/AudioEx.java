package project;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class AudioEx {
 private Clip clip;

 public AudioEx() {
     this.loadAudio("bgm 2.wav");
     this.clip.start();
 }

 private void loadAudio(String pathName) {
     try {
         this.clip = AudioSystem.getClip();
         File audioFile = new File(pathName);
         AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
         this.clip.open(audioStream);
     } catch (LineUnavailableException var4) {
         var4.printStackTrace();
     } catch (UnsupportedAudioFileException var5) {
         var5.printStackTrace();
     } catch (IOException var6) {
         var6.printStackTrace();
     }

 }

 public void audioPause() {
     this.clip.stop();
 }

 public void audioStart() {
     this.clip.start();
 }
}
