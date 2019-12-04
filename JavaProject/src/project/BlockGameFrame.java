package project;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.w3c.dom.Node;
import java.lang.*;	

public class BlockGameFrame extends JFrame {
 private XMLReader xml = new XMLReader("1stage.xml");
 int i=2;
 private XMLReader xml2 = new XMLReader(i+"stage.xml");
 StartPanel sp;
 private BlockGameFrame bgf;
// AudioEx audio = new AudioEx();
boolean isMute = false;
 TimerThread thread;

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
     GameToolbar gameToolbar = new GameToolbar(bgf);
 }

 public void setThread(TimerThread thread) {
     this.thread = thread;
 }
}
