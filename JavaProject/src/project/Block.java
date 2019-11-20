package project;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

class Block extends JLabel {
 private Image img = null;
 private int count = 0;
 private String countStr;

 public Block(int x, int y, int w, int h, ImageIcon icon, int type, GamePanel gp) {
     this.setBounds(x, y, w, h);
     if (icon != null) {
         this.img = icon.getImage();
     }

     this.count += type;
 }

 public void paintComponent(Graphics g) {
     if (this.img != null) {
         this.countStr = String.valueOf(this.count);
         g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);
         g.drawString(this.countStr, 20, 20);
     } else {
         g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
         this.countStr = String.valueOf(this.count);
         g.drawString(this.countStr, 20, 20);
     }

 }

 public void minusCount() {
     --this.count;
     this.repaint();
 }

 public int getCount() {
     return this.count;
 }
}
