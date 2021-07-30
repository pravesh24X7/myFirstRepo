package javaSwings;
import javax.swing.*;

public class VeryBasic {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        JButton jb = new JButton("click on me");
        jb.setBounds(130, 100, 100, 40);

        /* adding button in JFrame */
        jf.add(jb);
        jf.setSize(900, 500);
        jf.setLayout(null);
        jf.setVisible(true);
    }

}
