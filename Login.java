import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{

JLabel heading;
JButton b1;
JPasswordField pass;

Login() {
super("SBRM Hospital");
ImageIcon img = new ImageIcon("a.png");
this.setIconImage(img.getImage());

heading=new JLabel("Enter Password");
b1 = new JButton("Login");

pass=new JPasswordField(6);

heading.setBounds(290,75,100,25);
pass.setBounds(290,100,100,25) ;
b1.setBounds(290,150,100,30);
pass.setColumns(3);

setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(680, 300);

setLayout(null);
b1.addActionListener(this);

Color custom = new Color(40,224,208);
this.getContentPane().setBackground(custom);
b1.setBackground(Color.cyan);


JLabel background=new JLabel(new ImageIcon("a.png"));

background.setBounds(0,0,300,200);
	add(background);
add(heading);
add(pass);
add(b1);

}
public void actionPerformed(ActionEvent ae)
{

if(ae.getActionCommand()=="Login"){

		if(pass.getText().equals("123")){
		setVisible(false);
		Page1 t = new Page1 ();
		}

		else if(pass.getText().equals("admin@123")){
		setVisible(false);
		Page2 t = new Page2 ();
		}

		
		else
		JOptionPane.showMessageDialog(null, "Login Denied");
}
}

public static void main(String args[]) {

Login l = new Login();
}
}
