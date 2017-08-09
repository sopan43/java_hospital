import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Show extends JFrame implements ActionListener{

JButton b1,clear,back;
TextArea tArea;
JTextField getid;
JLabel heading,l;

Show(){
		super("SBRM Hospital");


			setLayout (null);
            		setSize(680, 600);
			b1 = new JButton("Search");
			clear = new JButton("Clear");
			back = new JButton("Back");

ImageIcon img = new ImageIcon("a.png");
this.setIconImage(img.getImage());

			l= new JLabel("Enter Patients ID/Name/Phone Number");
			heading=new JLabel("ENTER PATIENTS ID");
			getid=new JTextField(6);
			l.setBounds(250,25,200,25);
			getid.setBounds(290,50,100,25) ;
			b1.setBounds(290,100,100,30);
			add(b1);
			add(l);
			add(heading);
			add(getid);
			add(clear);
			add(back);
			back.setBounds(350,500,100,30);
			clear.setBounds(200,500,100,30);
			clear.addActionListener(this);
			b1.addActionListener(this);
			back.addActionListener(this);
			Color custom = new Color(40,224,208);
			this.getContentPane().setBackground(custom);
			b1.setBackground(Color.cyan);
			clear.setBackground(Color.cyan);
			back.setBackground(Color.cyan);
			
			
			
			tArea = new TextArea("");
 		tArea.setEditable(false); 
		
add (tArea);

tArea.setBounds (20, 210, 500, 250);  
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
			JLabel background=new JLabel(new ImageIcon("a.png"));

background.setBounds(0,0,300,200);
	add(background);
			
			
			
			
			
}


public void actionPerformed(ActionEvent ae){
	
	String str = getid.getText();
	if(str.length()==0)
		str="a";

if(ae.getActionCommand()=="Back"){
setVisible(false);
Page2 t = new Page2 ();
}








	if(ae.getActionCommand()=="Clear")
	{
		tArea.setText("");
		getid.setText("");
	}
	
	if(ae.getActionCommand()=="Search"){
			tArea.setText("");
		getid.setText("");
		
		
			
			if(Character.isDigit(str.charAt(0)) && str.length() !=10){
				
			
			try {
            
 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopu" , "root", "nikki");
            PreparedStatement st = con.prepareStatement("select * from Publisher where pid=?");
            st.setString(1, str);
 
           
            ResultSet rs = st.executeQuery();
				while(rs.next())
            {
          
                String s = rs.getString(1);
                String s1 = rs.getString(2);
                String s2 = rs.getString(3);
		String s4 = rs.getString(4);
                String s3 = rs.getString(5);
		String s5 = rs.getString(6);
		String s6 = rs.getString(7);
 
                
				
				tArea.append(s +"\t" + s1 +"\t"  + s2 +"\t"  + s4 +"\t" + s5 +"\t" + s6 +"\t"+ s3 + "\n" );
				
				
				
				
      
			}
 
            
        } catch (Exception ex) {
 
            System.out.println(ex);
        }
    }
	
	
	
	
	
	else if(Character.isLetter(str.charAt(0))){
				
			try {
            
 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopu" , "root", "nikki");
            PreparedStatement st = con.prepareStatement("select * from Publisher where pname=?");
            st.setString(1, str);
 
           
            ResultSet rs = st.executeQuery();
				while(rs.next())
            {
           
                String s = rs.getString(1);
                String s1 = rs.getString(2);
                String s2 = rs.getString(3);
		String s4 = rs.getString(4);
                String s3 = rs.getString(5);
		String s5 = rs.getString(6);
		String s6 = rs.getString(7);
 
                
				
				tArea.append(s +"\t" + s1 +"\t"  + s2 +"\t"  + s4 +"\t" + s5 +"\t" + s6 +"\t"+ s3 + "\n" );
				
			}
 
            
        } catch (Exception ex) {
 
            System.out.println(ex);
        }
    }
	
	
	
		else if(Character.isDigit(str.charAt(0)) && str.length() ==10){
				
			
			try {
            
 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopu" , "root", "nikki");
            PreparedStatement st = con.prepareStatement("select * from Publisher where pphone=?");
            st.setString(1, str);
 
            
            ResultSet rs = st.executeQuery();
				while(rs.next())
            {
           
                String s = rs.getString(1);
                String s1 = rs.getString(2);
                String s2 = rs.getString(3);
				String s4 = rs.getString(4);
                String s3 = rs.getString(5);
				String s5 = rs.getString(6);
				String s6 = rs.getString(7);
 
           
				
				tArea.append(s +"\t" + s1 +"\t"  + s2 +"\t"  + s4 +"\t" + s5 +"\t" + s6 +"\t"+ s3 + "\n" );
				
			}
 
            
        } catch (Exception ex) {
 
            System.out.println(ex);
        }
    }	
	
	
	
	
	
	if(tArea.getText().equals("")){
		JOptionPane.showMessageDialog(null, "No result found");
	}
	
	
	
	
}

}



public static void main(String args []){

//Show s = new Show();

}

}