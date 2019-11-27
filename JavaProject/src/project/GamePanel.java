package project;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class GamePanel extends JPanel {
 private ImageIcon bgImg;
 private Character character;
 XMLReader xml2;
 BlockGameFrame frame;
 private Bullet bullet;
 private Vector<Block> blockArr = new Vector();
 private GamePanel gp = this;
 private int limitTime;
 private JLabel timer;
 private TimerThread thread;
 int bcount;
 int bcount2;

 public GamePanel(Node gamePanelNode, final XMLReader xml2, final BlockGameFrame frame, int limit) {
     this.timer = new JLabel("Time : " + this.limitTime);
     this.bcount = 0;
     this.bcount2 = 0;
     this.frame = frame;
     this.xml2 = xml2;
     this.limitTime = limit;
     this.setLayout((LayoutManager)null);
     this.grabFocus();
     Node bgNode = XMLReader.getNode(gamePanelNode, XMLReader.E_BG);
     String filePath = bgNode.getTextContent();
     this.bgImg = new ImageIcon(filePath);
     Node blockNode = XMLReader.getNode(gamePanelNode, XMLReader.E_BLOCK);
     NodeList nodeList = blockNode.getChildNodes();

     for(int i = 0; i < nodeList.getLength(); ++i) {
         Node node = nodeList.item(i);
         if (node.getNodeType() == 1 && node.getNodeName().equals(XMLReader.E_OBJ)) {
             int x = Integer.parseInt(XMLReader.getAttr(node, "x"))+frame.getWidth()-1297;
             int y = Integer.parseInt(XMLReader.getAttr(node, "y"))+frame.getHeight()-737;
             int w = Integer.parseInt(XMLReader.getAttr(node, "w"));
             int h = Integer.parseInt(XMLReader.getAttr(node, "h"));
             int type = Integer.parseInt(XMLReader.getAttr(node, "type"));
             ImageIcon icon = null;
             String imgFilePath = XMLReader.getAttr(node, "img");
             if (imgFilePath != null) {
                 icon = new ImageIcon(imgFilePath);
             }

             Block block = new Block(x, y, w, h, icon, type, this.gp);
             this.add(block);
             this.blockArr.add(block);
             ++this.bcount;
         }
     }

     this.timer.setSize(300, 50);
     this.timer.setFont(new Font("Times Roman", 2, 40));
     this.timer.setLocation(this.frame.getWidth()/2, 0);
     this.add(this.timer);
     this.thread = new TimerThread(this.timer, 1000, "타이머", this.limitTime, frame);
     frame.setThread(this.thread);
this.character=  new Character((ImageIcon)null,this.frame);
     this.add(this.character);
     this.setFocusable(true);
     this.requestFocus();
     this.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
             if (e.getKeyCode() == 37) {
                 GamePanel.this.character.moveLeft();
             } else if (e.getKeyCode() == 39) {
                 GamePanel.this.character.moveRight();
             } else if (e.getKeyCode() == 32) {
                 GamePanel.this.bullet = new Bullet(GamePanel.this.blockArr, GamePanel.this.character, GamePanel.this.gp, xml2, frame);
                 GamePanel.this.add(GamePanel.this.bullet);
             } else if (e.getKeyCode()==KeyEvent.VK_DOWN){

                 GamePanel.this.character.moveDown();
             }
             else if (e.getKeyCode()==KeyEvent.VK_UP){
                 GamePanel.this.character.moveUp();
             }

         }
     });
 }

 public GamePanel(Node gamePanelNode2, BlockGameFrame frame, int limit) {
     this.timer = new JLabel("Time : " + this.limitTime);
     this.bcount = 0;
     this.bcount2 = 0;
     this.setLayout((LayoutManager)null);
     this.grabFocus();
     Node bgNode = XMLReader.getNode(gamePanelNode2, XMLReader.E_BG);
     String filePath = bgNode.getTextContent();
     this.bgImg = new ImageIcon(filePath);
     this.limitTime = limit;
     Node blockNode = XMLReader.getNode(gamePanelNode2, XMLReader.E_BLOCK);
     NodeList nodeList = blockNode.getChildNodes();

     for(int i = 0; i < nodeList.getLength(); ++i) {
         Node node = nodeList.item(i);

         if (node.getNodeType() == 1 && node.getNodeName().equals(XMLReader.E_OBJ)) {

             int x = Integer.parseInt(XMLReader.getAttr(node, "x"))+frame.getWidth()-1297;
             int y = Integer.parseInt(XMLReader.getAttr(node, "y"))+frame.getHeight()-737;
             int w = Integer.parseInt(XMLReader.getAttr(node, "w"));
             int h = Integer.parseInt(XMLReader.getAttr(node, "h"));
             int type = Integer.parseInt(XMLReader.getAttr(node, "type"));
             ImageIcon icon = null;
             String imgFilePath = XMLReader.getAttr(node, "img");
             if (imgFilePath != null) {
                 icon = new ImageIcon(imgFilePath);
             }

             Block block = new Block(x, y, w, h, icon, type, this.gp);
             this.add(block);
             this.blockArr.add(block);
         }
     }

     this.timer.setSize(300, 50);
     this.timer.setFont(new Font("Times Roman", 2, 40));
     this.timer.setLocation(800, 0);
     this.add(this.timer);
     this.thread = new TimerThread(this.timer, 1000, "타이머", this.limitTime, frame);
     frame.setThread(this.thread);
     this.character=  new Character((ImageIcon)null,frame);
     this.add(this.character);
     this.setFocusable(true);
     this.requestFocus();
     this.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
             if (e.getKeyCode() == 37) {
                 GamePanel.this.character.moveLeft();
             } else if (e.getKeyCode() == 39) {
                 GamePanel.this.character.moveRight();
             } else if (e.getKeyCode() == 32) {
                 GamePanel.this.bullet = new Bullet(GamePanel.this.blockArr, GamePanel.this.character, GamePanel.this.gp);
                 GamePanel.this.add(GamePanel.this.bullet);
             }else if (e.getKeyCode()==KeyEvent.VK_DOWN){

                 GamePanel.this.character.moveDown();
             }
             else if (e.getKeyCode()==KeyEvent.VK_UP){
                 GamePanel.this.character.moveUp();
             }

         }
     });
 }

 public void paintComponent(Graphics g) {
     g.drawImage(this.bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
     setSize(this.getWidth(),this.getHeight());
 }

 public void setThread(TimerThread thread) {
     this.thread = thread;
 }

 public TimerThread getThread() {
     return this.thread;
 }
}
