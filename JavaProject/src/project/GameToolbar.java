package project;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JToolBar;

public class GameToolbar extends JToolBar {
 private String filePath;

 public GameToolbar(final BlockGameFrame bgf) {
     JButton openBtn = new JButton(" Open ");
     openBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
             JFileChooser chooser = new JFileChooser();
             int ret = chooser.showOpenDialog(GameToolbar.this);
             if (ret == 0) {
                 String var4 = chooser.getSelectedFile().getPath();
             }

         }
     });
     JButton exitBtn = new JButton(" Exit ");
     exitBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
             System.exit(0);
         }
     });
     JButton rankingBtn = new JButton(" Ranking ");
     rankingBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
         }
     });
     JLabel pauseLabel = new JLabel(" Pause ");
     pauseLabel.addMouseListener(new MouseAdapter() {
         String beforeTitle = bgf.getTitle();

         public void mouseEntered(MouseEvent arg0) {
             bgf.setTitle(" Pause ");
         }

         public void mouseExited(MouseEvent arg0) {
             bgf.setTitle(this.beforeTitle);
         }
     });
     JButton upBtn = new JButton(" + ");
     upBtn.setSize(30, 30);
     JButton downBtn = new JButton(" -  ");
     upBtn.setSize(30, 30);
     JButton muteBtn = new JButton(" ¨ä ");
     muteBtn.setSize(30, 30);
     JButton helpBtn = new JButton(" help ");
     this.add(openBtn);
     this.addSeparator();
     this.add(exitBtn);
     this.addSeparator();
     this.add(rankingBtn);
     this.addSeparator();
     this.add(pauseLabel);
     this.addSeparator();
     this.addSeparator();
     this.add(upBtn);
     this.add(muteBtn);
     this.add(downBtn);
     this.addSeparator();
     this.addSeparator();
     this.addSeparator();
     this.addSeparator();
     this.add(helpBtn);
     this.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent arg0) {
             super.mouseEntered(arg0);
         }

         public void mouseExited(MouseEvent arg0) {
             super.mouseExited(arg0);
         }
     });
     this.setFloatable(false);
 }
}
