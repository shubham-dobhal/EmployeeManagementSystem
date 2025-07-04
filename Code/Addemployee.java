package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class Addemployee extends JFrame implements ActionListener {
    
    Random ran = new Random();
    int number = ran.nextInt(99999);
    
    JTextField tname, tfname, tsalary, taddress, tmail, tphone, tdesignation, taadhar;
    JButton add, back;
    JComboBox teducation;
    JLabel lblempId;
    JDateChooser cdob;

    Addemployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        add(tname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        add(labelfname);
        
        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        add(tfname);
        
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(dob);
        
        cdob = new JDateChooser();
        cdob.setBounds(200, 200, 150, 30);
        add(cdob);
        
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        add(salary);
        
        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        add(tsalary);
        
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        add(address);
        
        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        add(taddress);
        
        JLabel phone = new JLabel("Contact");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        add(phone);
        
        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        add(tphone);
        
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        add(email);
        
        tmail = new JTextField();
        tmail.setBounds(200, 300, 150, 30);
        add(tmail);
        
        JLabel education = new JLabel("Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("serif", Font.PLAIN, 20));
        add(education);
        
        String courses[] = { "BBA", "BCA", "BA", "B.COM", "BTECH", "MBA", "MCA", "MA", "MTECH", "MSC", "BSC" };
        teducation = new JComboBox(courses);
        teducation.setBackground(Color.WHITE);
        teducation.setBounds(600, 300, 150, 30);
        add(teducation);
        
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        add(designation);
        
        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        add(tdesignation);
        
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        add(aadhar);
        
        taadhar = new JTextField();
        taadhar.setBounds(600, 350, 150, 30);
        add(taadhar);
        
        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel("" + number);
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = tmail.getText();
            String education = (String) teducation.getSelectedItem();
            String designation = tdesignation.getText();
            String aadhar = taadhar.getText();
            String empId = lblempId.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into employee values('" + name + "', '" + fname + "','" + dob + "','" + salary + "','" + address + "','" + phone + "','" + email + "','" + education + "','" + designation + "','" + aadhar + "','" + empId + "')";
                conn.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String args[]) {
        new Addemployee();
    }

    private void add(JDateChooser cdob) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
