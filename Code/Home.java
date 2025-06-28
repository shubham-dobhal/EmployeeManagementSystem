package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    JButton add,view,update,remove;
    Home(){
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/home.jpg"));
    Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading=new JLabel("Employee management system");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(heading);
        
        add=new JButton("Add Employee");
        add.setBounds(355,270,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.addActionListener(this);
        image.add(add);
        
        view=new JButton("View Employees");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.black);
        view.addActionListener(this);
        image.add(view);
        
        update=new JButton("Update Employee");
        update.setBounds(565,370,150,40);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.black);
        update.addActionListener(this);
        image.add(update);
        
        remove=new JButton("Remove Employee");
        remove.setBounds(355,370,150,40);
        remove.setForeground(Color.WHITE);
        remove.setBackground(Color.black);
        remove.addActionListener(this);
        image.add(remove);
        
        
        
        
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            setVisible(false);
            new Addemployee();
            
        } else if(ae.getSource()==view){
            setVisible(false);
            new ViewEmployee();
        }else if(ae.getSource()==update){
            setVisible(false);
            new ViewEmployee();
        }else{
            setVisible(false);
            new RemoveEmployee();
        }
    }
    
    public static void main(String args[]){
        new Home();
    }
}
