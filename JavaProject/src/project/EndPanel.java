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

class EndPanel extends JPanel {
    BlockGameFrame frame;

    String id;
    private Image bg = (new ImageIcon("bgjpg.jpg")).getImage();
    GamePanel g;
    JLabel retryb;
    JLabel regameb;

    public EndPanel(BlockGameFrame frame) {
        this.frame = frame;
        this.setLayout((LayoutManager)null);
        this.setSize(1920,1080);
        this.retryb = new JLabel();
        ImageIcon imageIcon = new ImageIcon((new ImageIcon("retry.png")).getImage().getScaledInstance(frame.getWidth() / 4, frame.getHeight() / 8, 1));
        this.retryb.setIcon(imageIcon);
        this.retryb.setLocation(frame.getWidth() / 2 - frame.getWidth() / 8, frame.getHeight() / 2);
        System.out.println("log"+frame.getHeight());
        this.retryb.setSize(frame.getWidth() / 4, frame.getHeight() / 8);
        this.retryb.addMouseListener(new EndPanel.MyMouseListener());
        this.add(this.retryb);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.bg, 0, 0, this.frame.getWidth(), this.frame.getHeight(), this);
        this.retryb.setLocation(this.frame.getWidth()/2-this.frame.getWidth()/8,this.frame.getHeight()/2);
        System.out.println(this.frame.getWidth());

    }

    public GamePanel getGamePanel() {
        return this.g;
    }

    class MyMouseListener extends MouseAdapter {
        MyMouseListener() {
        }

        public void mouseClicked(MouseEvent e) {
            StartPanel sp = new StartPanel(EndPanel.this.frame);
            EndPanel.this.frame.setContentPane(sp);
            EndPanel.this.frame.revalidate();
            EndPanel.this.frame.repaint();
            EndPanel.this.frame.setFocusable(true);
            EndPanel.this.frame.requestFocus();
        }
    }
}
