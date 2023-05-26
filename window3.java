package bikers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class window3 extends JFrame {

    // importing pictures
    ImageIcon harley_C = new ImageIcon("C:\\Users\\roong\\OneDrive\\المستندات\\NetBeansProjects\\bikers\\src\\harley_c.jpg");
    ImageIcon ducati_c = new ImageIcon("C:\\Users\\roong\\OneDrive\\المستندات\\NetBeansProjects\\bikers\\src\\ducati_c.jpg");
    ImageIcon triumph_c = new ImageIcon("C:\\Users\\roong\\OneDrive\\المستندات\\NetBeansProjects\\bikers\\src\\truimph_c.jpg");

    ImageIcon ducati_o = new ImageIcon("C:\\Users\\roong\\OneDrive\\المستندات\\NetBeansProjects\\bikers\\src\\ducati_o.jpg");
    ImageIcon honda_o = new ImageIcon("C:\\Users\\roong\\OneDrive\\المستندات\\NetBeansProjects\\bikers\\src\\honda_o.jpg");
    ImageIcon truimph_o = new ImageIcon("C:\\Users\\roong\\OneDrive\\المستندات\\NetBeansProjects\\bikers\\src\\triumph_o.jpg");

    ImageIcon kawasaki_t = new ImageIcon("C:\\Users\\roong\\OneDrive\\المستندات\\NetBeansProjects\\bikers\\src\\kawasaki(touring).jpg");
    ImageIcon honda_t = new ImageIcon("C:\\Users\\roong\\OneDrive\\المستندات\\NetBeansProjects\\bikers\\src\\honda(touring).jpg");
    ImageIcon bmw_t = new ImageIcon("C:\\Users\\roong\\OneDrive\\المستندات\\NetBeansProjects\\bikers\\src\\bmw(touring).jpg");

    //putting pictures in labels
    //city bikes
    JLabel harley_cl = new JLabel(harley_C);
    JLabel ducati_cl = new JLabel(ducati_c);
    JLabel triumph_cl = new JLabel(triumph_c);

    
    JLabel ducati_ol = new JLabel(ducati_o);
    JLabel honda_ol = new JLabel(honda_o);
    JLabel truimph_ol = new JLabel(truimph_o);

    JLabel honda_tl = new JLabel(honda_t);
    JLabel bmw_tl = new JLabel(bmw_t);
    JLabel kawasaki_tl = new JLabel(kawasaki_t);

    // main panel for viewing picture
    JPanel pic_c = new JPanel();
    JScrollPane jsp_c = new JScrollPane(pic_c);
    
    JPanel pic_o = new JPanel();
    JScrollPane jsp_o = new JScrollPane(pic_o);
    
    JPanel pic_t = new JPanel();
    JScrollPane jsp_t = new JScrollPane(pic_t);

    //making a radiobuttons for type of bikes  
    JRadioButton city_type = new JRadioButton("city bikes");
    JRadioButton offroad_type = new JRadioButton("offroad bikes");
    JRadioButton touring_type = new JRadioButton("touring bikes");
    JPanel p = new JPanel();
    JButton back = new JButton("Back");
    
    //bike info for city bike
    JPanel harley_panel = new JPanel();
    JLabel harley_information = new JLabel("this is harley devison street 750 ");
    JLabel harley_price = new JLabel("price: 250");
    JButton harley_button = new JButton("select");   

    JPanel ducati_cpanel = new JPanel();
    JLabel ducati_cinformation = new JLabel("this is ducati scrambler 62 ");
    JLabel ducati_cprice = new JLabel("price: 230");
    JButton ducati_cbutton = new JButton("select");

    JPanel triumph_cpanel = new JPanel();
    JLabel triumph_cinformation = new JLabel("this is triumph street cup");
    JLabel triumph_cprice = new JLabel("price: 220");
    JButton triumph_cbutton = new JButton("select");

    //bike info for offroad bike
    JPanel ducati_opanel = new JPanel();
    JLabel ducati_oinformation = new JLabel("this is ducati desert x ");
    JLabel ducati_oprice = new JLabel("price: 170");
    JButton ducati_obutton = new JButton("select");

    JPanel honda_opanel = new JPanel();
    JLabel honda_oinformation = new JLabel("this is honda africa twin");
    JLabel honda_oprice = new JLabel("price: 160");
    JButton honda_obutton = new JButton("select");

    JPanel triumph_panel = new JPanel();
    JLabel triumph_information = new JLabel("this is triumph tiger 1200");
    JLabel triumph_price = new JLabel("price: 150");
    JButton triumph_button = new JButton("select");

    //bike info for touring bike
    JPanel bmw_panel = new JPanel();
    JLabel bmw_information = new JLabel("this is bmw k1600g");
    JLabel bmw_price = new JLabel("price: 350");
    JButton bmw_button = new JButton("select");

    JPanel honda_tpanel = new JPanel();
    JLabel honda_information = new JLabel("this is honda goldwing");
    JLabel honda_price = new JLabel("price: 330");
    JButton honda_tbutton = new JButton("select");

    JPanel kawasaki_panel = new JPanel();
    JLabel kawasaki_information = new JLabel("this is kawasaki ninja 1000sx");
    JLabel kawasaki_price = new JLabel("price: 370");
    JButton kawasaki_button = new JButton("select");
    
    int rental ;

    public window3() {

        setTitle("bikers");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        
    
        ButtonGroup group = new ButtonGroup();
        group.add(city_type);
        group.add(offroad_type);
        group.add(touring_type);
        
        add(p);
        
        p.setBounds(600,200,150,120);
        p.add(city_type);
        p.add(offroad_type);
        p.add(touring_type);
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "select type", TitledBorder.CENTER, TitledBorder.TOP)));
        
        add(back);
        back.setBounds(70, 440, 100, 30);
        
        
        city_type.addActionListener(new Action());
        offroad_type.addActionListener(new Action());
        touring_type.addActionListener(new Action());
        
        //connecting city bikes button to action listener
        harley_button.addActionListener(new bAction());
        ducati_cbutton.addActionListener(new bAction());
        triumph_cbutton.addActionListener(new bAction());
        
        
        
        //connecting offraod bikes button to action listener
        ducati_obutton.addActionListener(new bAction());
        honda_obutton.addActionListener(new bAction());
        triumph_button.addActionListener(new bAction());
        
        
        //connecting touring bikes button to action listener
        bmw_button.addActionListener(new bAction());
        honda_tbutton.addActionListener(new bAction());
        kawasaki_button.addActionListener(new bAction());

        back.addActionListener(new bAction());
        setVisible(true);

    }


            private class Action implements ActionListener{  

        @Override
        public void actionPerformed(ActionEvent ae) {
           
            
            if(city_type.isSelected()){
                citybike();
                jsp_c.setVisible(true);
                jsp_o.setVisible(false);
                jsp_t.setVisible(false);
                setVisible(true);
           } 
            
            if(offroad_type.isSelected()){
                offroadbike();
                jsp_c.setVisible(false);
                jsp_o.setVisible(true);
                jsp_t.setVisible(false);
                setVisible(true);
           } 
            
            if(touring_type.isSelected()){
                touringbike();
                jsp_c.setVisible(false);
                jsp_o.setVisible(false);
                jsp_t.setVisible(true);
                setVisible(true);
            } 
           
            
            
            
            
        }
 
    }
    
    private class bAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //base price for bikes
            //prices for city bikes
            if (ae.getSource() == harley_button ) {
                rental = 250;
            }  if (ae.getSource() == ducati_cbutton) {     
                rental = 230;
            }  if(ae.getSource() == triumph_cbutton){         
                rental = 220;
            }
            
            //prices for offroad bikes
               if (ae.getSource() == ducati_obutton) {        
                rental = 170;
            }  if (ae.getSource() == honda_obutton) {        
                rental = 160;
            }  if(ae.getSource() == triumph_button){        
                rental = 150;
            }
                                     
             //prices for touring bikes
               if (ae.getSource() == bmw_button) {         
                rental = 350;
            }  if (ae.getSource() == honda_tbutton) {        
                rental = 330;
            }  if (ae.getSource() == kawasaki_button) {      
                rental = 370;
            }
             
            
            new window4(rental);
            dispose();
            
            if(ae.getSource() == back){
                new window2("back");
                dispose();
            }
        }
    }

    public void citybike() {
        if (true) {
            //gridlayout for main panel
            pic_c.setLayout(new GridLayout(3, 2, 5, 30));
            
            //adding bike picture
            pic_c.add(harley_cl);
            //adding bike panel information
            pic_c.add(harley_panel);
            //adding bike picture
            pic_c.add(ducati_cl);
            //adding bike panel information
            pic_c.add(ducati_cpanel);
            //adding bike picture
            pic_c.add(triumph_cl);
            //adding bike panel information
            pic_c.add(triumph_cpanel);

            //information for each bike
            //layout for indivsiual component (harley) 
            harley_panel.setLayout(null);
            harley_panel.add(harley_information);
            harley_information.setBounds(50, 30, 200, 100);
            harley_panel.add(harley_price);
            harley_price.setBounds(50, 60, 200, 100);
            harley_panel.add(harley_button);
            harley_button.setBounds(90, 150, 80, 25);
            
            //layout for indivsiual component (ducati) 
            ducati_cpanel.setLayout(null);
            ducati_cpanel.add(ducati_cinformation);
            ducati_cinformation.setBounds(50, 30, 200, 100);
            ducati_cpanel.add(ducati_cprice);
            ducati_cprice.setBounds(50, 60, 200, 100);
            ducati_cpanel.add(ducati_cbutton);
            ducati_cbutton.setBounds(90, 150, 80, 25);
            
             //layout for indivsiual component (triumph)
            triumph_cpanel.setLayout(null);
            triumph_cpanel.add(triumph_cinformation);
            triumph_cinformation.setBounds(50, 30, 200, 100);
            triumph_cpanel.add(triumph_cprice);
            triumph_cprice.setBounds(50, 60, 200, 100);
            triumph_cpanel.add(triumph_cbutton);
            triumph_cbutton.setBounds(90, 150, 80, 25);

            //adding scrollpane for the main panel
            Container c = this.getContentPane();
            jsp_c.setBounds(10, 80, 550, 350);
            jsp_c.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "bikes model", TitledBorder.CENTER, TitledBorder.TOP)));
            c.add(jsp_c);


        }
    }

    public void offroadbike() {
        if (true) {
           //gridlayout for main panel
            pic_o.setLayout(new GridLayout(3, 2, 5, 30));
            
            //adding bike picture
            pic_o.add(ducati_ol);
            //adding bike panel information
            pic_o.add(ducati_opanel);
            //adding bike picture
            pic_o.add(honda_ol);
            //adding bike panel information
            pic_o.add(honda_opanel);
            //adding bike picture
            pic_o.add(truimph_ol);
            //adding bike panel information
            pic_o.add(triumph_panel);
            
            //information for each bike
            //layout for indivsiual component (ducati) 
            ducati_opanel.setLayout(null);
            ducati_opanel.add(ducati_oinformation);
            ducati_oinformation.setBounds(50, 30, 200, 100);
            ducati_opanel.add(ducati_oprice);
            ducati_oprice.setBounds(50, 60, 200, 100);
            ducati_opanel.add(ducati_obutton);
            ducati_obutton.setBounds(90, 150, 80, 25);

            //layout for indivsiual component (honda) 
            honda_opanel.setLayout(null);
            honda_opanel.add(honda_oinformation);
            honda_oinformation.setBounds(50, 30, 200, 100);
            honda_opanel.add(honda_oprice);
            honda_oprice.setBounds(50, 60, 200, 100);
            honda_opanel.add(honda_obutton);
            honda_obutton.setBounds(90, 150, 80, 25);
            
            //layout for indivsiual component (triumph) 
            triumph_panel.setLayout(null);
            triumph_panel.add(triumph_information);
            triumph_information.setBounds(50, 30, 200, 100);
            triumph_panel.add(triumph_price);
            triumph_price.setBounds(50, 60, 200, 100);
            triumph_panel.add(triumph_button);
            triumph_button.setBounds(90, 150, 80, 25);

            //adding scrollpane for the main panel
            Container c = this.getContentPane();
            jsp_o.setBounds(10, 80, 550, 350);
            jsp_o.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "bikes model", TitledBorder.CENTER, TitledBorder.TOP)));
            c.add(jsp_o);

        }
    }

    public void touringbike() {

        if (true) {
        //gridlayout for main panel
            pic_t.setLayout(new GridLayout(3, 2, 5, 30));
            //adding bike picture
            pic_t.add(bmw_tl);
            //adding bike panel information
            pic_t.add(bmw_panel);
            //adding bike picture
            pic_t.add(honda_tl);
            //adding bike panel information
            pic_t.add(honda_tpanel);
            //adding bike picture
            pic_t.add(kawasaki_tl);
            //adding bike panel information
            pic_t.add(kawasaki_panel);

           //information for each bike
            //layout for indivsiual component (bmw)
            bmw_panel.setLayout(null);
            bmw_panel.add(bmw_information);
            bmw_information.setBounds(50, 30, 200, 100);
            bmw_panel.add(bmw_price);
            bmw_price.setBounds(50, 60, 200, 100);
            bmw_panel.add(bmw_button);
            bmw_button.setBounds(90, 150, 80, 25);

            //layout for indivsiual component (honda) 
            honda_tpanel.setLayout(null);
            honda_tpanel.add(honda_information);
            honda_information.setBounds(50, 30, 200, 100);
            honda_tpanel.add(honda_price);
            honda_price.setBounds(50, 60, 200, 100);
            honda_tpanel.add(honda_tbutton);
            honda_tbutton.setBounds(90, 150, 80, 25);
            
            //layout for indivsiual component (kawasaki) 
            kawasaki_panel.setLayout(null);
            kawasaki_panel.add(kawasaki_information);
            kawasaki_information.setBounds(50, 30, 200, 100);
            kawasaki_panel.add(kawasaki_price);
            kawasaki_price.setBounds(50, 60, 200, 100);
            kawasaki_panel.add(kawasaki_button);
            kawasaki_button.setBounds(90, 150, 80, 25);

            //adding scrollpane for the main panel
            Container c = this.getContentPane();
            jsp_t.setBounds(10, 80, 550, 350);
            jsp_t.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "bikes model", TitledBorder.CENTER, TitledBorder.TOP)));
            c.add(jsp_t);

        }
    }

   
    
    public static void main(String[] args) {

        new window3();
    }
}
