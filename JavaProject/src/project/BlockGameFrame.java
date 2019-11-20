package project;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import org.w3c.dom.Node;
import java.lang.*;	

public class BlockGameFrame extends JFrame {
 private XMLReader xml = new XMLReader("1stage.xml");
 private XMLReader xml2 = new XMLReader("2stage.xml");
 private StartPanel sp;
 private BlockGameFrame bgf;
 private AudioEx audio = new AudioEx();
 private boolean isMute = false;
 private TimerThread thread;

 public BlockGameFrame() {
     this.setTitle(" R U N ");
     Node blockGameNode = this.xml.getBlockGameElement();
     Node sizeNode = XMLReader.getNode(blockGameNode, XMLReader.E_SIZE);
     Node blockGameNode2 = this.xml2.getBlockGameElement();
     Node sizeNode2 = XMLReader.getNode(blockGameNode2, XMLReader.E_SIZE);
     String w = XMLReader.getAttr(sizeNode, "w");
     String h = XMLReader.getAttr(sizeNode, "h");
     this.setSize(Integer.parseInt(w), Integer.parseInt(h));
     this.setDefaultCloseOperation(3);
     this.bgf = this;
     this.sp = new StartPanel(this.bgf, this.xml, this.xml2);
     this.setContentPane(this.sp);
     this.createMenu();
     this.setResizable(false);
     this.setVisible(true);
     this.setFocusable(true);
     this.requestFocus();
 }

 public StartPanel getStartPanel() {
     return this.sp;
 }

 public static void main(String[] args) {
     new BlockGameFrame();
 }

 private void createMenu() {
     final JMenuBar bar = new JMenuBar();
     JMenu menu = new JMenu(" M E N U ");
     JMenuItem pause = new JMenuItem(" P A U S E ");
     JMenuItem start = new JMenuItem(" S T A R T ");
     pause.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
             BlockGameFrame.this.audio.audioPause();
             bar.requestFocus();
             BlockGameFrame.this.bgf.setTitle(" P A U S E ");
             BlockGameFrame.this.thread.pause();
         }
     });
     start.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
             BlockGameFrame.this.audio.audioStart();
             BlockGameFrame.this.sp.getGamePanel().requestFocus();
             BlockGameFrame.this.bgf.setTitle(" R U N ");
             BlockGameFrame.this.thread.pause();
         }
     });
     JMenuItem help = new JMenuItem(" H E L P ");
     help.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
             String help = "도움말입니다.\n이동은 좌, 우 방향키로 할 수 있습니다.\n공격은 'space bar'로 가능합니다.\n 매뉴를 누르시면 음소거 및 일시정지 기능이 있습니다.\n";
             JOptionPane.showMessageDialog((Component)null, help, (String)null, -1);
         }
     });
     JMenuItem mute = new JMenuItem(" M U T E ");
     mute.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
             BlockGameFrame.this.isMute = !BlockGameFrame.this.isMute;
             if (BlockGameFrame.this.isMute) {
                 BlockGameFrame.this.audio.audioPause();
             } else {
                 BlockGameFrame.this.audio.audioStart();
             }

         }
     });
     JMenuItem exit = new JMenuItem(" E X I T ");
     exit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
             System.exit(0);
         }
     });
     menu.add(pause);
     menu.addSeparator();
     menu.add(start);
     menu.addSeparator();
     menu.add(mute);
     menu.addSeparator();
     menu.add(help);
     menu.addSeparator();
     menu.add(exit);
     bar.add(menu);
     this.setJMenuBar(bar);
 }

 public void setThread(TimerThread thread) {
     this.thread = thread;
 }
}
