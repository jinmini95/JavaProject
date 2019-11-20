package project;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

class Character extends JLabel {
 private int x = 0;
 private int y = 0;
 private Image img = null;
 Bullet b;
 Image ch = (new ImageIcon("รั.png")).getImage();

 public Character(ImageIcon icon) {
     this.x = 900;
     this.y = 900;
     this.setLocation(900, 900);
     this.setSize(35, 112);
     if (icon != null) {
         this.img = icon.getImage();
     }

     this.setOpaque(false);
 }

 public void paintComponent(Graphics g) {
     if (this.img != null) {
         g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);
     } else {
         g.setColor(Color.YELLOW);
         g.drawImage(this.ch, -2, -15, this.getWidth() * 5 / 3, this.getHeight() * 5 / 3, this);
     }

 }

 public void moveLeft() {
     if (this.x > 0) {
         this.x -= 30;
     }

     this.setLocation(this.x, this.y);
     this.getParent().repaint();
 }

 public void moveRight() {
     if (this.x < 1800) {
         this.x += 30;
     }

     this.setLocation(this.x, this.y);
     this.getParent().repaint();
 }

 public int getX() {
     return this.x;
 }

 public int getY() {
     return this.y;
 }
}
