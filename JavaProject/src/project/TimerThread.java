package project;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import java.awt.Component;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class TimerThread extends Thread {
 private JLabel label;
 private int delay;
 boolean flag = true;
 private int limit;

 public TimerThread(JLabel label, int delay, String name, int limit, BlockGameFrame blockGameFrame) {
     super(name);
     this.label = label;
     this.delay = delay;
     this.limit = limit;
     this.start();
 }

 public synchronized void pause() {
     this.flag = !this.flag;
     if (this.flag) {
         this.notify();
     }

 }

 public synchronized void checkFlag() {
     if (!this.flag) {
         try {
             System.out.println("before wait");
             this.wait();
             System.out.println("after wait");
         } catch (InterruptedException var2) {
             return;
         }
     }

 }

 public void run() {
     while(true) {
         this.label.setText("Time : " + this.limit);
         if (this.limit == 0) {
             String end = "시간초과!!\n게임에서 패배하셨습니다.";
             JOptionPane.showConfirmDialog((Component)null, end, (String)null, -1);
             System.exit(0);
         }

         try {
             sleep((long)this.delay);
             this.checkFlag();
             --this.limit;
         } catch (InterruptedException var3) {
             Container c = this.label.getParent();
             c.remove(this.label);
             c.repaint();
             return;
         }
     }
 }

 public void killThread() {
     this.interrupt();
 }
}
