package project;

//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class GameToolbar  {
 private String filePath;

 public GameToolbar(final BlockGameFrame bgf) {
     final JMenuBar bar = new JMenuBar();

     JMenu menu = new JMenu(" M E N U ");
     JMenuItem pause = new JMenuItem(" P A U S E ");
     JMenuItem start = new JMenuItem(" S T A R T ");

     pause.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
   //          bgf.audio.audioPause();
             bar.requestFocus();
             bgf.setTitle(" P A U S E ");
             bgf.thread.pause();
         }
     });
     start.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
      //       bgf.audio.audioStart();
             bgf.sp.getGamePanel().requestFocus();
            bgf.setTitle(" R U N ");
             bgf.thread.pause();
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
             bgf.isMute = !bgf.isMute;
             if (bgf.isMute) {
        //         bgf.audio.audioPause();
             } else {
         //        bgf.audio.audioStart();
             }

         }
     });
     JMenuItem exit = new JMenuItem(" E X I T ");

     exit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
             System.exit(0);
         }
     });
     JMenuItem rank = new JMenuItem(" R A N K ");
     rank.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent actionEvent) {

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
     menu.addSeparator();
     menu.add(rank);
     menu.addSeparator();
     bar.add(menu);


    bgf.setJMenuBar(bar);

 }
}
