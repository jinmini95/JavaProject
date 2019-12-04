package project;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class StartPanel extends JPanel {
 BlockGameFrame frame;


 String id;
 private Image bg = (new ImageIcon("bgjpg.jpg")).getImage();
 GamePanel g;
 JLabel startb;

 public StartPanel(BlockGameFrame frame) {
     this.frame = frame;

     this.setLayout((LayoutManager)null);
     this.setSize(1920,1080);
     this.startb = new JLabel();
     ImageIcon imageIcon = new ImageIcon((new ImageIcon("start.png")).getImage().getScaledInstance(frame.getWidth() / 4, frame.getHeight() / 8, 1));
     this.startb.setIcon(imageIcon);
     this.startb.setLocation(frame.getWidth() / 2 - frame.getWidth() / 8, frame.getHeight() / 2);
     System.out.println("log"+frame.getHeight());
     this.startb.setSize(frame.getWidth() / 4, frame.getHeight() / 8);
     this.startb.addMouseListener(new StartPanel.MyMouseListener());
     this.add(this.startb);
 }

 public void paintComponent(Graphics g) {
     super.paintComponent(g);
     g.drawImage(this.bg, 0, 0, this.frame.getWidth(), this.frame.getHeight(), this);
this.startb.setLocation(this.frame.getWidth()/2-this.frame.getWidth()/8,this.frame.getHeight()/2);
     System.out.println(this.frame.getWidth());
 }

 public GamePanel getGamePanel() {
     return this.g;
 }

 class MyMouseListener extends MouseAdapter {
     MyMouseListener() {
     }

     public void mouseClicked(MouseEvent e) {
         StartPanel.this.g = new GamePanel(BlockGameFrame.xml.getGamePanelElement(), BlockGameFrame.xml, StartPanel.this.frame, 60);
         StartPanel.this.frame.setContentPane(StartPanel.this.g);
         StartPanel.this.frame.revalidate();
         StartPanel.this.frame.repaint();
         StartPanel.this.g.setFocusable(true);
         StartPanel.this.g.requestFocus();
     }
 }
}
