
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class updateEmployee extends JFrame implements ActionListener{ 
    JTextField tfeducation,tfname,tsalary,taddress,tmail,tphone,tdesignation;
    JButton add,back;
    JLabel lblempId;
    String empId;
    
    updateEmployee(String empId){
        this.empId=empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel  heading=new JLabel("update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        JLabel  labelfname=new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(labelfname);
         
        tfname=new JTextField();
        tfname.setBounds(600,150,150,30);
        add(tfname);
        
        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SERIF",Font.PLAIN,20));
        add(dob);
        
        JLabel lbldob=new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        JLabel  salary=new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(salary);
        
         tsalary=new JTextField();
        tsalary.setBounds(600,200,150,30);
        add(tsalary);
        
        JLabel address=new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(address);
        
        taddress=new JTextField();
        taddress.setBounds(200,250,150,30);
        add(taddress);
        
         JLabel phone=new JLabel("phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(phone);

        tphone=new JTextField();
        tphone.setBounds(600,250,150,30);
        add(tphone);
        
        
         JLabel email=new JLabel("email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(email);
        
        tmail=new JTextField("abc@gmail.com");
        tmail.setBounds(200,300,150,30);
        add(tmail);
        
         JLabel education=new JLabel("Education");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("serif",Font.PLAIN,20));
        add(education);
        
        
        tfeducation=new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        JLabel designation=new JLabel("Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(designation);
        
        tdesignation=new JTextField();
        tdesignation.setBounds(200,350,150,30);
        add(tdesignation);
        
        JLabel aadhar=new JLabel("Aadhar Number");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        add(aadhar);

          JLabel lblaadhar=new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);
        
        JLabel labelempId=new JLabel("Employee id");
        labelempId.setBounds(50,400,150,30);
       labelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempId);
        
        lblempId=new JLabel();
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where empId='"+empId+"'";
             ResultSet  rs=c.st.executeQuery(query);
             while(rs.next()){
                 lblname.setText(rs.getString("name"));
                 tfname.setText(rs.getString("fname"));
                 lbldob.setText(rs.getString("dob"));
                  taddress.setText(rs.getString("address"));
                  tsalary.setText(rs.getString("salary"));
                  tphone.setText(rs.getString("phone"));
                  tmail.setText(rs.getString("email"));
                  tfeducation.setText(rs.getString("education"));
                  lblaadhar.setText(rs.getString("aadhar"));
                  lblempId.setText(rs.getString("empId"));
                  tdesignation.setText(rs.getString("designation"));
             }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        add=new JButton("update Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String fname=tfname.getText();
            String salary=tsalary.getText();
            String address=taddress.getText();
            String phone=tphone.getText();
            String email=tmail.getText();
            String education=tfeducation.getText();
            String designation=tdesignation.getText();
            
            
            try{
              Conn c=new Conn();
              String query="update employee set fname = '"+fname+"', salary ='"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
              c.st.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Details update successfully");
              setVisible(false);
              new Home();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else{
            setVisible(false);
            new Home();
            
        }
    }
    public static void main(String args[]){
        new updateEmployee("");
    }
}
