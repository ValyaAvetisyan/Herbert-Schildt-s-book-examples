package old.stack;

import javax.swing.*;
import java.awt.ActiveEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window extends JFrame {

    BraceChecker braceChaker = new BraceChecker();
    private String str;
    private String res;

    window() {
        //this.braceChaker = new BraceChecker();

        JPanel panel = new JPanel();
        JButton parse = new JButton("parse");
        JTextArea textArea = new JTextArea();

        textArea.setLineWrap(true);
        textArea.setEditable(true);
        textArea.setVisible(true);
        JTextField fild = new JTextField();

        JScrollPane scroll = new JScrollPane(textArea);

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        parse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                str = textArea.getText();
                parceText();
                res =  braceChaker.getResultMessage();
                 fild.setText(res);
                System.out.println("parse button is cliced");

            }
        });

        panel.add(parse);
        add(panel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(fild, BorderLayout.SOUTH);

        setSize(450, 350);
        setLocation(100, 100);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void massage() {
        System.out.println(braceChaker.toString());

    }

    public void parceText() {
        braceChaker.parse(str);

    }

    public void fild() {
        window win = new window();

    }

    public static void main(String[] args) {
        window win = new window();
        win.massage();
    }
}
