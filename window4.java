package bikers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import static java.lang.System.in;
import javax.swing.border.TitledBorder;

public class window4 extends JFrame {

    JPanel info = new JPanel();
    JPanel creidet = new JPanel();
    JLabel name = new JLabel();
    JLabel city = new JLabel();
    JLabel neighborhood = new JLabel();
    JLabel phone = new JLabel();
    JLabel zip_code = new JLabel();
    JLabel bill_title = new JLabel("Bill information");
    JLabel customer_info = new JLabel("customer information");
    JLabel cost = new JLabel();

    // labels to inform user to enter his card info
    JLabel card_title = new JLabel("please enter your criedet card information");
    JLabel card_number = new JLabel("card number");
    JLabel card_date = new JLabel("expire date");
    JLabel card_ccv = new JLabel("card cvt");

    //text filed to take user card information
    JTextField card_number_field = new JTextField();
    JTextField card_date_field = new JTextField();
    JTextField card_ccv_field = new JTextField();

    //button
    JButton confirme = new JButton("Confirme");
    JButton back = new JButton("Back");

    public window4(int rental) {

        setTitle("bikers");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        
        //costumer information section
        add(bill_title);
        bill_title.setBounds(350, 50, 250, 50);

        add(confirme);
        confirme.setBounds(420, 400, 100, 30);

        add(back);
        back.setBounds(265, 400, 100, 30);

        cost.setText("motorbike cost : " + rental);
        
        buildPabnel1();

        buildPabnel2();
        
        setVisible(true);
        
        confirme.addActionListener(new action());
        
        back.addActionListener(new action());
    }

    private class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == confirme) {
                try {

                    check_number(card_number_field.getText());
                    check_date(card_date_field.getText());
                    check_ccv(card_ccv_field.getText());
                    JOptionPane.showMessageDialog(null, "your order is confirmed ");
                    dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            }
            if (ae.getSource() == back) {
                new window3();
                dispose();

            }

        }
    }

    public void buildPabnel1() {

        
        try {
            FileInputStream f = new FileInputStream("user_data.dat");
            ObjectInputStream d = new ObjectInputStream(f);

            user u1 = null;
            u1 = (user) d.readObject();
            name.setText("customer name :  " + u1.name);
            name.setBounds(85, 40, 300, 30);

            city.setText("customer city :  " + u1.city);
            city.setBounds(85, 80, 200, 30);

            phone.setText("customer phone number :  " + u1.number);
            phone.setBounds(85, 120, 250, 30);

            neighborhood.setText("customer neighborhood :  " + u1.neighborhood);
            neighborhood.setBounds(85, 160, 350, 30);

            zip_code.setText("city zip code :  " + u1.zip_code);
            zip_code.setBounds(85, 200, 150, 30);

            d.close();
            f.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        info.add(city);
        info.add(name);
        info.add(phone);
        info.add(neighborhood);
        info.add(zip_code);
        add(info);
        info.setBounds(10, 120, 370, 250);
        info.setLayout(null);
        info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "costumer_info", TitledBorder.CENTER, TitledBorder.TOP)));

    }

    public void buildPabnel2() {

        //costumer card information
        add(creidet);
        creidet.setBounds(400, 120, 370, 250);
        creidet.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "card_info", TitledBorder.CENTER, TitledBorder.TOP)));
        creidet.setLayout(null);

        //all labels in card info
        creidet.add(cost);
        cost.setBounds(105, 40, 300, 30);

        creidet.add(card_title);
        card_title.setBounds(85, 80, 300, 30);

        creidet.add(card_number);
        card_number.setBounds(55, 130, 300, 30);

        creidet.add(card_date);
        card_date.setBounds(55, 170, 300, 30);

        creidet.add(card_ccv);
        card_ccv.setBounds(230, 170, 300, 30);

        //all textfields in card info
        creidet.add(card_number_field);
        card_number_field.setBounds(145, 130, 200, 30);

        creidet.add(card_date_field);
        card_date_field.setBounds(130, 170, 80, 30);

        creidet.add(card_ccv_field);
        card_ccv_field.setBounds(290, 172, 55, 30);

    }
    
    public static void check_number(String massege) throws Exception {

        int counter = 1;

        if (massege.length() == 0) {
            throw new Exception("please enter your card number");
        }
        if (massege.length() < 16 || massege.length() > 16) {
            throw new Exception("please enter 16 numbers only in card number");
        }
        while (counter < 16) {
            if (!Character.isDigit(massege.charAt(counter))) {

                throw new Exception("please use numbers only in card number");
            }
            counter++;
        }

    }

    public static void check_date(String massege) throws Exception {

        int counter = 1;

        if (massege.length() == 0) {
            throw new Exception("please enter your card expire date");
        }
        if (massege.length() < 5 || massege.length() > 5) {
            throw new Exception("please enter 4 numbers only and '/' after the second number");
        }
        while (counter < 5) {
            if (counter == 2) {

                if (massege.charAt(2) != '/') {

                    throw new Exception("please enter '/' after the second digit");

                }

            } else if (!Character.isDigit(massege.charAt(counter))) {

                throw new Exception("please enter month and year 2 digit");
            }
            counter++;
        }
    }

    public static void check_ccv(String massege) throws Exception {

        int counter = 1;

        if (massege.length() == 0) {
            throw new Exception("please enter your card ccv");
        }
        if (massege.length() < 3 || massege.length() > 3) {
            throw new Exception("please enter 3 numbers only in ccv");
        }
        while (counter < 3) {
            if (!Character.isDigit(massege.charAt(counter))) {

                throw new Exception("please use numbers only in ccv");
            }
            counter++;
        }
    }

    public static void main(String[] args) {

        new window4(220);
    }

}
