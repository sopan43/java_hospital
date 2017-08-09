import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Page1 extends JFrame implements ActionListener{


JButton b1,b2,b3;

Page1(){
super("SBRM Hospital");




ImageIcon img = new ImageIcon("a.png");
this.setIconImage(img.getImage());


b1 = new JButton("Insert");
b2 = new JButton("Logout");

b1.addActionListener(this);
b2.addActionListener(this);


b1.setBounds(175,200,100,30);
b2.setBounds(325,200,100,30);

b1.setBackground(Color.cyan);
b2.setBackground(Color.cyan);

setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(600, 300);
Color custom = new Color(40,224,208);
setLayout(null);



JLabel background=new JLabel(new ImageIcon("a.png"));

background.setBounds(0,0,600,200);
	add(background);


add(b1);
add(b2);
this.getContentPane().setBackground(custom);
}
public void actionPerformed(ActionEvent ae)
{
    
if(ae.getActionCommand()=="Logout"){
setVisible(false);
Login l = new Login();
}


if(ae.getActionCommand()=="Insert")
    
{


try{
PublisherInfo p = new PublisherInfo ();
  
p.compshow();
setVisible(false);
}

catch(Exception e)
    
{
    
System.out.println("Error1 "+e);
    

    
} 

}
}
public static void main(String arr[]){

//Page1 p = new Page1();

}
}

