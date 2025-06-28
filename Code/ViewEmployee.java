
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class ViewEmployee extends JFrame implements ActionListener {
    JTable table;
    Choice cempId;
            
    JButton lsearch,print,update,back;
   ViewEmployee(){
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel search=new JLabel("search by name");
       search.setBounds(20,20,150,20);
       add(search);
       
       cempId =new Choice();
       cempId.setBounds(180,20,150,20);
       add(cempId);
       
       try{
           Conn c =new Conn();
           ResultSet rs=c.st.executeQuery("select * from employee");
           
           while(rs.next()){
               cempId.add(rs.getString("name"));
           }
       }
       catch(Exception e){
           e.printStackTrace();
}
table =new JTable();

       try {
           Conn c =new Conn();
           ResultSet rs=c.st.executeQuery("select * from employee");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           }
       catch(Exception e){
           e.printStackTrace();
       }
       
       JScrollPane jsp=new JScrollPane(table);
       jsp.setBounds(0,100,900,600);
       add(jsp);
       
       lsearch =new JButton("search");
       lsearch.setBounds(20,70,80,20);
       lsearch.addActionListener(this);
       add(lsearch);
       
        print =new JButton("print");
       print.setBounds(120,70,80,20);
       print.addActionListener(this);
       add(print);
       
        update=new JButton("update");
       update.setBounds(220,70,80,20);
       update.addActionListener(this);
       add(update);
       
       back =new JButton("Back");
       back.setBounds(320,70,80,20);
      back.addActionListener(this);
       add(back);
       
       
       setSize(900,700);
       setLocation(300,100);
       setVisible(true);
   }
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()== lsearch){
           String query="select * from employee where name= '"+cempId.getSelectedItem()+"'";
           
           try{
               Conn c=new Conn();
               ResultSet rs=c.st.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
           }
           catch(Exception e){
               e.printStackTrace();
           }
       }
       else if(ae.getSource()== print){
           try{
             table.print();
           }
           catch(Exception e){
               e.printStackTrace();
           }
       }
       else if(ae.getSource()== update){
           setVisible(false);
           new updateEmployee(cempId.getSelectedItem());
       }
       else {
           setVisible(false);
           new Home();
       }
   }
    
    public static void main(String args[]){
        new ViewEmployee();
    }
}
