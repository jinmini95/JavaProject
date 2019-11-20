package project;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class Bullet extends JLabel implements Runnable {
 private int ballRadius = 10;
 private int ballX;
 private int ballY;
 private int ballSpeedY = -20;
 private Thread th = new Thread(this);
 private Vector<Block> v;
 XMLReader xml2;
 BlockGameFrame frame;
 GamePanel g2;
 private int x = 30;
 private GamePanel gamePanel;
 Image bu = (new ImageIcon("bu.png")).getImage();

 public Bullet(Vector<Block> v, Character c, GamePanel gp) {
     this.setBounds(c.getX(), c.getY(), this.ballRadius * 2, this.ballRadius * 2);
     this.ballX = c.getX() + c.getWidth() / 2;
     this.ballY = c.getY();
     this.v = v;
     this.gamePanel = gp;
     this.th.start();
 }

 public Bullet(Vector<Block> v, Character c, GamePanel gp, XMLReader xml2, BlockGameFrame frame) {
     this.xml2 = xml2;
     this.frame = frame;
     this.setBounds(c.getX(), c.getY(), this.ballRadius * 2, this.ballRadius * 2);
     this.ballX = c.getX() + c.getWidth() / 2;
     this.ballY = c.getY();
     this.v = v;
     this.gamePanel = gp;
     this.th.start();
 }

 public void run() {
     while(true) {
         this.ballY += this.ballSpeedY;
         if (this.ballY + this.ballSpeedY < 0) {
             this.th.interrupt();
             this.getParent().remove(this);
             this.revalidate();
             this.repaint();
             this.gamePanel.repaint();
             return;
         }

         for(int i = 0; i < this.v.size(); ++i) {
             if (this.ballX + this.ballRadius > ((Block)this.v.get(i)).getX() - 5 && this.ballX + this.ballRadius * 2 < ((Block)this.v.get(i)).getX() + ((Block)this.v.get(i)).getWidth() + 5 && this.ballY < ((Block)this.v.get(i)).getY() + ((Block)this.v.get(i)).getHeight()) {
                 if (((Block)this.v.get(i)).getCount() == 1) {
                     this.getParent().remove((Component)this.v.get(i));
                     this.v.remove(i);
                     this.repaint();
                     this.th.interrupt();
                     this.getParent().remove(this);
                     this.revalidate();
                     this.repaint();
                     this.gamePanel.repaint();
                     --this.gamePanel.bcount;
                     if (this.gamePanel.bcount == 0) {
                         this.gamePanel.getThread().killThread();
                         String help = "STAGE CLEAR!!\n이번 단계는 너무 쉬웠죠?\n다음단계부터는 본격적으로\n어려워질꺼니 집중하시고\n이제 시~~작!!!!";
                         JOptionPane.showMessageDialog((Component)null, help, (String)null, -1);
                         this.g2 = new GamePanel(this.xml2.getGamePanelElement(), this.frame, 100);
                         this.frame.setContentPane(this.g2);
                         this.frame.revalidate();
                         this.frame.repaint();
                         this.g2.setFocusable(true);
                         this.g2.requestFocus();
                     }
                 } else {
                     ((Block)this.v.get(i)).minusCount();
                     this.th.interrupt();
                     this.getParent().remove(this);
                     this.revalidate();
                     this.repaint();
                     this.gamePanel.repaint();
                 }
             }
         }

         try {
             this.setLocation(this.ballX, this.ballY);
             this.repaint();
             Thread.sleep((long)this.x);
             this.repaint();
         } catch (InterruptedException var3) {
             this.repaint();
             return;
         }
     }
 }

 public void paintComponent(Graphics g) {
     super.paintComponent(g);
     g.setColor(Color.ORANGE);
     g.drawImage(this.bu, 0, 0, this.ballRadius * 2, this.ballRadius * 2, this);
 }
}
