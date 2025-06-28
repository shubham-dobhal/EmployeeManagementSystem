
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
 Splash(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel heading=new JLabel("Employee Management system");
    heading.setBounds(80,30,1200,60);
    heading.setFont(new Font("serif",Font.PLAIN,60));
    heading.setForeground(Color.red);
    add(heading);

    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/front.gif"));
    Image i2=i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3); 
        image.setBounds(0,0,1170,650);
        add(image);
        
    JButton clickhere=new JButton("click here");
    clickhere.setBounds(400,535,300,70);
    clickhere.setBackground(Color.BLACK);
    clickhere.setForeground(Color.WHITE);
    clickhere.addActionListener(this);
    image.add(clickhere);
    
            
            

        setSize(1170,650);
        setLocation(200,50);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

         try{
            Thread.sleep(5000);
        }catch(Exception e){
         
        }
         heading.setVisible(true);
         try{
             Thread.sleep(5000);
         }
         catch(Exception e){
             
         }

        
    }
 public void actionPerformed(ActionEvent e){
     setVisible(false);
     new Login();
 }
 
 
    public static void main(String args[]){
        new Splash();
    }
}

