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

import static project.GamePanel.stageCount;

class Bullet extends JLabel implements Runnable {
 private int ballRadius = 10;
 private int ballX;
 private int ballY;
 private int ballSpeedY = -20;
 private Thread th = new Thread(this);
 private Vector<Block> v;
 EndPanel ep;
 BlockGameFrame frame;
 GamePanel g2;
 private int x = 30;
 private GamePanel gamePanel;


 Image bu = (new ImageIcon("bu.png")).getImage();

 public Bullet(Vector<Block> v, Character c, GamePanel gp, BlockGameFrame frame) {

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
try{        this.getParent().remove(this);}
            catch(NullPointerException e){
    return;
            }

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
                         if(stageCount==1) {
                        this.gamePanel.getThread().killThread();
                             String help = "STAGE CLEAR!!\n이번 단계는 너무 쉬웠죠?\n다음단계부터는 본격적으로\n어려워질꺼니 집중하시고\n이제 시~~작!!!!";
                         JOptionPane.showMessageDialog((Component) null, help, (String) null, -1);
                         this.gamePanel = new GamePanel(BlockGameFrame.xml2.getGamePanelElement(), BlockGameFrame.xml2, this.frame, 100);
                         this.frame.setContentPane(this.gamePanel);
                         this.frame.revalidate();
                         this.frame.repaint();
                         this.gamePanel.setFocusable(true);
                         this.gamePanel.requestFocus();
                         GamePanel.flag=true;
                         GamePanel.stageCount++;
                     }
                         else if(gamePanel.stageCount==2){
                             this.gamePanel.getThread().killThread();
                             String help = "STAGE CLEAR!!\n이번 단계는 너무 쉬웠죠?\n다음단계부터는 본격적으로\n어려워질꺼니 집중하시고\n홀리쉿";
                             JOptionPane.showMessageDialog((Component)null, help, (String)null, -1);
                             this.gamePanel=new GamePanel(BlockGameFrame.xml3.getGamePanelElement(),BlockGameFrame.xml3, this.frame, 100);
                             this.frame.setContentPane(this.gamePanel);
                             this.frame.revalidate();
                             this.frame.repaint();
                             this.gamePanel.setFocusable(true);
                             this.gamePanel.requestFocus();
                             GamePanel.flag=true;
                             GamePanel.stageCount++;
                         }
                         else if(gamePanel.stageCount==3){
                          this.gamePanel.getThread().killThread();
                             String help = "STAGE CLEAR!!\n이번 단계는 너무 쉬웠죠?\n다음단계부터는 본격적으로\n어려워질꺼니 집중하시고\n홀리쉿";
                             JOptionPane.showMessageDialog((Component)null, help, (String)null, -1);
                             this.gamePanel=new GamePanel(BlockGameFrame.xml4.getGamePanelElement(),BlockGameFrame.xml4, this.frame, 100);
                             this.frame.setContentPane(this.gamePanel);
                             this.frame.revalidate();
                             this.frame.repaint();
                             this.gamePanel.setFocusable(true);
                             this.gamePanel.requestFocus();
                             GamePanel.flag=true;
                             GamePanel.stageCount++;
                         }
                         else if(gamePanel.stageCount==4){
                           this.gamePanel.getThread().killThread();
                             String help = "STAGE CLEAR!!\n이번 단계는 너무 쉬웠죠?\n다음단계부터는 본격적으로\n어려워질꺼니 집중하시고\n홀리쉿";
                             JOptionPane.showMessageDialog((Component)null, help, (String)null, -1);
                             this.ep = new EndPanel(this.frame);
                             this.frame.setContentPane(this.ep);
                             this.frame.setResizable(false);
                             this.setVisible(true);
                             this.setFocusable(true);
                             this.requestFocus();
                             GamePanel.stageCount=1;
                         }
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
