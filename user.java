package bikers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Bikers extends JFrame {

    JLabel name = new JLabel("enter your name");
    JLabel title = new JLabel("welcome to bikers rentals");
    ImageIcon image = new ImageIcon("C:\\Users\\roong\\OneDrive\\المستندات\\NetBeansProjects\\bikers\\src\\v3.gif");
    JLabel bikes = new JLabel(image);
    JButton button = new JButton("Continue");
    JTextField text = new JTextField(10);

    JMenuBar menuBar = new JMenuBar();
    JMenu FontMenu = new JMenu("Font");
    JMenuItem fmItem1 = new JMenuItem("Dialog");
    JMenuItem fmItem2 = new JMenuItem("DialogInput");
    JMenuItem fmItem3 = new JMenuItem("Monospaced");
    JMenuItem fmItem4 = new JMenuItem("SansSerif");
    JMenuItem fmItem5 = new JMenuItem("Serif");
    JMenu sizeMenu = new JMenu("Size");
    JMenuItem mItemIncrease = new JMenuItem("Increase");
    JMenuItem mItemDecrease = new JMenuItem("Decrease");
    JMenu color = new JMenu("color");
    JMenuItem choose_color = new JMenuItem("choose color");
    public Bikers() {

        setTitle("bikers");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        add(bikes);

        bikes.setBounds(250, 100, 300, 210);

        add(text);
        text.setBounds(270, 350, 250, 50);

        add(name);
        name.setBounds(150, 350, 250, 50);

        add(title);
        title.setBounds(320, 50, 250, 50);

        add(button);
        button.setBounds(630, 420, 100, 30);
        button.addActionListener(new buttonaction());
        // button.setEnabled(false);

        buildMenu();
        super.setJMenuBar(menuBar);

        setVisible(true);
    }

    public void buildMenu() {
        // Text Menu
        menuBar.add(FontMenu);

        FontMenu.add(fmItem1);
        FontMenu.add(fmItem2);
        FontMenu.add(fmItem3);
        FontMenu.add(fmItem4);
        FontMenu.add(fmItem5);
        FontMenu.addSeparator();

        // size Menu
        menuBar.add(sizeMenu);
        sizeMenu.add(mItemIncrease);
        sizeMenu.add(mItemDecrease);

        menuBar.add(color);
        color.add(choose_color);
        
        fmItem1.addActionListener(new FontNameAction());
        fmItem2.addActionListener(new FontNameAction());
        fmItem3.addActionListener(new FontNameAction());
        fmItem4.addActionListener(new FontNameAction());
        fmItem5.addActionListener(new FontNameAction());

        mItemIncrease.addActionListener(new FontSizeAction());
        mItemDecrease.addActionListener(new FontSizeAction());

        
        choose_color.addActionListener(new ColorChooserAction());
    }

    private class FontSizeAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == mItemIncrease) {
                text.setFont(new Font(text.getFont().getFontName(), text.getFont().getStyle(), text.getFont().getSize() + 3));

            } else if (e.getSource() == mItemDecrease) {
                text.setFont(new Font(text.getFont().getFontName(), text.getFont().getStyle(), text.getFont().getSize() - 3));

            }
        }
    }

    private class FontNameAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == fmItem1) {

                Font t = new Font("Dialog", text.getFont().getStyle(), text.getFont().getSize());
                text.setFont(t);

            } else if (e.getSource() == fmItem2) {

                text.setFont(new Font("DialogInput", text.getFont().getStyle(), text.getFont().getSize()));

            } else if (e.getSource() == fmItem3) {
                text.setFont(new Font("Monospaced", text.getFont().getStyle(), text.getFont().getSize()));

            } else if (e.getSource() == fmItem4) {
                text.setFont(new Font("SansSerif", text.getFont().getStyle(), text.getFont().getSize()));

            } else if (e.getSource() == fmItem5) {
                text.setFont(new Font("Serif", text.getFont().getStyle(), text.getFont().getSize()));

            }
        }
    }

    public class buttonaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                String name = text.getText();
                check(name);
                 new window2(name);
                 dispose();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }

        }

    }

    public static void check(String massege) throws Exception {

        int counter = 0;

        if (massege.length() == 0) {
            throw new Exception("please enter your name");
        }
        while (counter < massege.length()) {
            if (Character.isDigit(massege.charAt(counter))) {

                throw new Exception("please use letters only");
            }
            counter++;
        }

    }

    private class ColorChooserAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            Color selected = JColorChooser.showDialog(null, "select text color", Color.GREEN);
            text.setForeground(selected);
        }
    }
    
    public static void main(String[] args) {

        new Bikers();
    }

}
