
package bikers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
   
public class window2 extends JFrame{
    
    String[] cities = { "jeddah","makkah", "riyadh","baljurashi", "dammam"};
    JComboBox city = new JComboBox(cities);
    JTextField neighborhood = new JTextField(20);
    JTextField phone = new JTextField(20);
    JTextField zip = new JTextField(20);
    JLabel lneighborhood = new JLabel("enter your neighborhood");
    JLabel lcity = new JLabel("enter your city");
    JLabel lphone = new JLabel("enter your phone number");
    JLabel lzip = new JLabel("enter city zipcode");
    JLabel lname = new JLabel();
    JButton next = new JButton("Continue");
    JButton back = new JButton("Back");
    String user_name;
    
    
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
    
    public window2(String name){
        setTitle("bikers");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        user_name = name;
        
        add(lname);
        lname.setBounds(350,20,400,70);
        lname.setText("hello "+name);
        
        
        add(city);
        city.setBounds(180,150,150,30);
        
        add(lcity);
        lcity.setBounds(85,150,150,30);
        
        add(neighborhood);
        neighborhood.setBounds(550,150,150,30);
       
        add(lneighborhood);
        lneighborhood.setBounds(400, 150, 150, 30);
         
        
        add(phone);
        phone.setBounds(180,250,150,30);
        
        add(lphone);
        lphone.setBounds(25,250,150,30);
        
        add(zip);
        zip.setBounds(550,250,150,30);
       
        add(lzip);
        lzip.setBounds(435, 250, 150, 30);
                
        add(next);
        next.setBounds(480, 400, 100, 30);
        
        add(back);
        back.setBounds(250, 400, 100, 30); 
        
        
        next.addActionListener(new nextaction());
        
        back.addActionListener(new nextaction());
        
        
        buildMenu();
        super.setJMenuBar(menuBar);
        
        
        
        
        
        
        
        
        setVisible(true);
    }   
    
         public void buildMenu(){
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
         private class FontSizeAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == mItemIncrease){
                phone.setFont(new Font(phone.getFont().getFontName(), phone.getFont().getStyle(), phone.getFont().getSize() + 3));
                zip.setFont(new Font(zip.getFont().getFontName(), zip.getFont().getStyle(), zip.getFont().getSize() + 3));
                neighborhood.setFont(new Font(neighborhood.getFont().getFontName(), neighborhood.getFont().getStyle(), neighborhood.getFont().getSize() + 3));

            }else if(e.getSource() == mItemDecrease){
                phone.setFont(new Font(phone.getFont().getFontName(), phone.getFont().getStyle(), phone.getFont().getSize() - 3));
                zip.setFont(new Font(zip.getFont().getFontName(), zip.getFont().getStyle(), zip.getFont().getSize() - 3));
                neighborhood.setFont(new Font(neighborhood.getFont().getFontName(), neighborhood.getFont().getStyle(), neighborhood.getFont().getSize() - 3));
            }
        }
    }
    
   
    
    private class FontNameAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == fmItem1){
                
                
                Font p =  new Font("Dialog", phone.getFont().getStyle(), phone.getFont().getSize());
                phone.setFont(p);
                Font z =  new Font("Dialog", zip.getFont().getStyle(), zip.getFont().getSize());
                zip.setFont(z);
                Font n =  new Font("Dialog", neighborhood.getFont().getStyle(), neighborhood.getFont().getSize());
                neighborhood.setFont(n);
                
            }else if(e.getSource() == fmItem2){
                
                phone.setFont(new Font("DialogInput", phone.getFont().getStyle(), phone.getFont().getSize()));
                zip.setFont(new Font("DialogInput", zip.getFont().getStyle(), zip.getFont().getSize()));
                neighborhood.setFont(new Font("DialogInput", neighborhood.getFont().getStyle(), neighborhood.getFont().getSize()));
                
            }else if(e.getSource() == fmItem3){
                phone.setFont(new Font("Monospaced", phone.getFont().getStyle(), phone.getFont().getSize()));
                zip.setFont(new Font("Monospaced", zip.getFont().getStyle(), zip.getFont().getSize()));
                neighborhood.setFont(new Font("Monospaced", neighborhood.getFont().getStyle(), neighborhood.getFont().getSize()));

            }else if(e.getSource() == fmItem4){
                phone.setFont(new Font("SansSerif", phone.getFont().getStyle(), phone.getFont().getSize()));
                zip.setFont(new Font("SansSerif", zip.getFont().getStyle(), zip.getFont().getSize()));
                neighborhood.setFont(new Font("SansSerif", neighborhood.getFont().getStyle(), neighborhood.getFont().getSize()));

            }else if(e.getSource() == fmItem5){
                phone.setFont(new Font("Serif", phone.getFont().getStyle(), phone.getFont().getSize()));
                zip.setFont(new Font("Serif", zip.getFont().getStyle(), zip.getFont().getSize()));
                neighborhood.setFont(new Font("Serif", neighborhood.getFont().getStyle(), neighborhood.getFont().getSize()));
            }
        }
    }
    
   private class ColorChooserAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            Color selected = JColorChooser.showDialog(null, "select text color", Color.GREEN);
            neighborhood.setForeground(selected);
            zip.setForeground(selected);
            phone.setForeground(selected);
        }
    }
         
         
    public class nextaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
           
            if (ae.getSource() == next) {
                String user_city = (String) city.getSelectedItem();
                try {
                    check(neighborhood.getText());
                    check_number(phone.getText());
                    check_zipcode(zip.getText());
                    new window3();
                    dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

                try {
                    FileOutputStream f = new FileOutputStream("user_data.dat");
                    ObjectOutputStream d = new ObjectOutputStream(f);
                    user u1 = new user(user_name, user_city, neighborhood.getText(), phone.getText(), zip.getText());
                    d.writeObject(u1);
                    d.close();
                    f.close();
                } catch (FileNotFoundException ex) {
                    System.out.println(ex);
                } catch (IOException ex) {
                    System.out.println(ex);
                } catch (Exception ex) {
                    Logger.getLogger(window2.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (ae.getSource() == back) {
                
                new Bikers();
                dispose();
            }
        }



    }
    
    
     public static void check(String massege) throws Exception {

        int counter = 0;

        if (massege.length() == 0) {
            throw new Exception("please enter your neighborhood");
        }
        while (counter < massege.length()) {
            if (Character.isDigit(massege.charAt(counter))) {

                throw new Exception("please use letters only in neighborhood");
            }
            counter++;
        }

    }
     public static void check_number(String massege) throws Exception {

        int counter = 1;

        if (massege.length() == 0) {
            throw new Exception("please enter your phone number");
        }
        if( massege.length() < 10 || massege.length() > 10){
            throw new Exception("please enter 10 numbers only in phone number");
        }
        
        while (counter < 10) {
            if (!Character.isDigit(massege.charAt(counter))) {

                throw new Exception("please use number only in phone number");
            }
            counter++;
        }

    } public static void check_zipcode(String massege) throws Exception {

        int counter = 1;

        if (massege.length() == 0) {
            throw new Exception("please enter your zip code");
        }
        
        if( massege.length() < 5 || massege.length() > 5){
            throw new Exception("please enter 5 numbers only in zip code");
        }
            
        while (counter < 5) {
            if (!Character.isDigit(massege.charAt(counter))) {

                throw new Exception("please use number only in zip code");
            }
            counter++;
            
        }

    }
    public static void main(String[] args) {
        
        
        new window2("rayan");
    }
}
