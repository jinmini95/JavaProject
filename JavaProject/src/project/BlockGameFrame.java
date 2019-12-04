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
 static XMLReader xml = new XMLReader("1stage.xml");
 static XMLReader xml2 = new XMLReader("2stage.xml");
    static XMLReader xml3 = new XMLReader("3stage.xml");
    static XMLReader xml4 = new XMLReader("4stage.xml");
EndPanel ep;
 StartPanel sp;
 private BlockGameFrame bgf;
// AudioEx audio = new AudioEx();
boolean isMute = false;
 TimerThread thread;

 public BlockGameFrame() {
     this.setTitle(" R U N ");
    Node blockGameNode = this.xml.getBlockGameElement();
     Node sizeNode = XMLReader.getNode(blockGameNode, XMLReader.E_SIZE);
     /* Node blockGameNode2 = this.xml2.getBlockGameElement();
     Node sizeNode2 = XMLReader.getNode(blockGameNode2, XMLReader.E_SIZE);
     Node blockGameNode3 = this.xml3.getBlockGameElement();
     Node sizeNode3 = XMLReader.getNode(blockGameNode3, XMLReader.E_SIZE);
     Node blockGameNode4 = this.xml4.getBlockGameElement();
     Node sizeNode4 = XMLReader.getNode(blockGameNode4, XMLReader.E_SIZE);*/
     String w = XMLReader.getAttr(sizeNode, "w");
     String h = XMLReader.getAttr(sizeNode, "h");
     this.setSize(Integer.parseInt(w), Integer.parseInt(h));
     this.setDefaultCloseOperation(3);
     this.bgf = this;

  this.sp = new StartPanel(this.bgf);
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
