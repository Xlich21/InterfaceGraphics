package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui implements ActionListener {
    private JButton button;
    private JFrame window;
    private DrawPanel panel;

    public static void main(String[] args) {
        new SimpleGui().run();
    }

    protected void run() {
        window = new JFrame();
        button = new JButton("Change color");
        panel = new DrawPanel();
        button.addActionListener(this);

        window.getContentPane().add(BorderLayout.SOUTH, button);
        window.getContentPane().add(BorderLayout.CENTER, panel);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(300, 300);
        window.setVisible(true);

        moveCercle();
    }

    protected void changeText() {
        button.setText("You clicked me");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        changeText();
        changeColor();
     //   moveCercle();
    }

    private void moveCercle() {
        for (int x = 0; x <= 200; x++){
            panel.setXY(x, x);
            window.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void changeColor() {
        window.repaint();
    }
}