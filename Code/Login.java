
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
JTextField tusername;
 JTextField tpassword;
JButton login,back;

  Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);
        
        JLabel p = new JLabel("Password");
        p.setBounds(40, 70, 100, 30);
        add(p);
        
        tusername = new JTextField();
        tusername.setBounds(150, 20, 100, 30);
        add(tusername);
        
        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 100, 30);
        add(tpassword);
        
        login = new JButton("Login");
        login.setBounds(100, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        back = new JButton("BACK");
        back.setBounds(100, 180, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350, 0, 200, 200);
        add(img);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  public void actionPerformed(ActionEvent ae){
      try{
          String username=tusername.getText();
          String password =tpassword.getText();
          Conn conn = new Conn();
          String query = "SELECT * from login where username='" + username + "' AND password='" + password + "'";
          
          ResultSet rs = conn.st.executeQuery(query);
          if (rs.next()){
              setVisible(false);
              new Home();
          }
          else{
               JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);

          }
      }
      catch(Exception e){
          e.printStackTrace();
      }
  }
  public static void main(String args[]){
      new Login();
  }
}
        