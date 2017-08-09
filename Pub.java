import java.awt.*;
import java.awt.event.*; 
import java.sql.*; 
import javax.swing.*;

public class Pub extends JFrame implements ActionListener{

	String sidnew="12";
	int idnewid=0;
	JLabel heading, lpubid, lpub_name, lphone, laddress, lcity, lstate,lzip,error; 
	JTextField pub_idField, pub_nameField, addressField, phoneField,stateField, zipField;
	JButton insert, back, newid, search,clear;
	TextArea cityField;
	JComboBox doctor;
	 String[] doctorname= { "Dr. Pooja Seth",  "Dr. Sana ", "Dr. Atul Mishra", "Dr. Sagar",  "Dr. Jass", "Dr. Ravi Teja", "Dr. Vikas"};  
	
Connection con;
PreparedStatement stat; 
Statement stmt; ResultSet rs;

		public Pub() {
     super("SBRM Hospital");

     
		try     
		{
  
      
/*Initialize and load Type 4 driver*/
  
   
		Class.forName("com.mysql.jdbc.Driver");

  
      
/*Connect to a data source*/
    
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sopu" , "root", "nikki");
  
      
/*Create a Statement object*/
  
      
		stmt = con.createStatement();      
		}
	     
		catch(Exception e)     
		{
  
      
		System.out.println("Error : "+e);     
		}
		}


public void compshow(){


heading=new JLabel("PATIENTS INFORMATION");
    
lpubid=new JLabel("Patients ID:");
    
lpub_name=new JLabel("Patients Name:");
    
lphone=new JLabel("Phone Number:");
    
laddress=new JLabel("Gender:");
    
lcity=new JLabel("Description:");
    
lstate=new JLabel("Doctor:");
    
lzip=new JLabel("Date: \n (DD/MM/YYYY)");











Color custom = new Color(40,224,208);
this.getContentPane().setBackground(custom);




doctor = new JComboBox (doctorname); 
            doctor.addActionListener (this);


JRadioButton rbtMale = new JRadioButton("Male");
			JRadioButton rbtFemale = new JRadioButton("Female",true);
			ButtonGroup sex = new ButtonGroup();
			
			sex.add(rbtMale);
			sex.add(rbtFemale);
	rbtFemale.setBackground(custom);
rbtMale.setBackground(custom);	
			add(rbtMale);
			add(rbtFemale);


pub_idField=new JTextField(6);
    
pub_nameField=new JTextField(50);
    
phoneField=new JTextField(15);
    
addressField=new JTextField(50);
    
//cityField=new JTextField(50);
cityField = new TextArea("Age: ");
    
stateField=new JTextField(50);
    
zipField=new JTextField(20);



insert=new JButton("Insert");
    
back=new JButton("Back");
  search = new JButton("Search");
newid=new JButton("NewId");
clear = new JButton("Clear");

insert.setBackground(Color.cyan);
search.setBackground(Color.cyan);
newid.setBackground(Color.cyan);
clear.setBackground(Color.cyan);
back.setBackground(Color.cyan);

setLayout(null);
    
heading.setBounds(250,35,200,40);
    
add(heading);


lpubid.setBounds(75,90,200,30);
    
pub_idField.setBounds(400,90,100,25) ;
    
add(lpubid);
    
add(pub_idField);




lpub_name.setBounds(75,120,200,30);
    
pub_nameField.setBounds(400,120,200,25);
    
add(lpub_name);
    add(pub_nameField);
  
    
lphone.setBounds(75,150,200,30);
    
phoneField.setBounds(400,150,150,25);
    
add(lphone);
    
add(phoneField);
  
    
laddress.setBounds(75,180,200,30);
    
//addressField.setBounds(400,180,250,25);
rbtFemale.setBounds(500,180,100,30);
rbtMale.setBounds(400,180,100,30);
 

add(laddress);
    
//add(addressField);
  
    
lcity.setBounds(75,210,200,30);
    
cityField.setBounds(400, 210,150,75);
    
add(lcity);
    
add(cityField);
  
add(doctor);
doctor.setBounds(400,290,200,25);





  
lstate.setBounds(75,290,200,30);
    
//stateField.setBounds(400,290,200,25);
    
add(lstate);
    
//add(stateField);
  
    
lzip.setBounds(75,320,200,30);
    
zipField.setBounds(400,320,200,25);
    
add(lzip);
    
add(zipField);
  
    


search.setBounds(470,400,100,30);

 
clear.setBounds(110,400,100,30);
insert.setBounds(230,400,100,30);
back.setBounds(350,400,100,30);
newid.setBounds(550,85,100,30);
    zipField.setText("");
add(insert);
 add(back);
add(newid);
add(search);
add(clear);


JLabel background=new JLabel(new ImageIcon("a.png"));

background.setBounds(0,0,600,470);
	add(background);


ImageIcon img = new ImageIcon("a.png");
this.setIconImage(img.getImage());





setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(680, 500);

setLayout(null);
  
clear.addActionListener(this);
insert.addActionListener(this);
    
back.addActionListener(this);
newid.addActionListener(this);
search.addActionListener(this);
rbtMale.addActionListener(this);


	addressField.setText("Female"); 
}





public void actionPerformed(ActionEvent ae)
{
	pub_nameField.setEditable(true);
if(ae.getActionCommand()=="NewId"){

int a=0;

 try
        {
String str = "SELECT * From Publisher order by pid";
ResultSet rs = stmt.executeQuery(str);

String id="0";
          

            while(rs.next())
            {
                id=rs.getString("pid");
               
            }
			
a = Integer.parseInt(id);

idnewid = a+1;

		}
		 catch(Exception ex)
        {
            System.out.println("Error occurred");
            System.out.println("Error:"+ex);
        }


pub_idField.setEditable(false);
sidnew = String.valueOf(idnewid);
pub_idField.setText(sidnew);
}


if(ae.getActionCommand()=="Male"){
	addressField.setText("Male");
}

if(ae.getActionCommand()=="Female"){
	addressField.setText("Female");
}


    
 if(ae.getActionCommand()=="Back"){
setVisible(false);
Page2 t = new Page2 ();
}



if(ae.getActionCommand()=="Clear"){
	
	pub_idField.setEditable(true);
	pub_nameField.setEditable(true);
	pub_idField.setText("");
     
pub_nameField.setText("");
     
phoneField.setText("");
     
//addressField.setText("vvgfgyg");
     
cityField.setText("Age: ");

        
stateField.setText("");
      
  
zipField.setText("");
}




if(ae.getActionCommand()=="Search"){

try {
            String str = pub_idField.getText();
 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sopu" , "root", "nikki");
            PreparedStatement st = con.prepareStatement("select * from publisher where pid=?");
            st.setString(1, str);
 
            //Excuting Query
            ResultSet rs = st.executeQuery();
 
            if (rs.next()) {
                String s = rs.getString(2);
                String s1 = rs.getString(3);
                String s2 = rs.getString(4);
 
                //Sets Records in TextFields.
                pub_nameField.setText(s);
               phoneField.setText(s1);
			   pub_idField.setEditable(false);
				pub_nameField.setEditable(false);
                
            } else {
                JOptionPane.showMessageDialog(null, "Name not Found");
				pub_idField.setEditable(true);
	pub_nameField.setEditable(true);
            }
 
            //Create Exception Handler
        } catch (Exception ex) {
 
            System.out.println(ex);
        }

}
 if(ae.getActionCommand()=="Insert")
   
{
    
//Insert a row in the Patients table
    
try
    
{
    
stat = con.prepareStatement("INSERT INTO Publisher VALUES(?, ?, ?, ?, ?,?,?)");
        
String pid = pub_idField.getText();
  
   
String pname = pub_nameField.getText();
  
   
String pphone = phoneField.getText();
  
   
String padd = addressField.getText();
  
   
String pcity = cityField.getText();
      
//String pstate = stateField.getText();
String  pstate= (String) doctor.getSelectedItem();    
String pzip = zipField.getText();  
stat.setString(1, pid);   
stat.setString(2, pname);
stat.setString(3, pphone);
stat.setString(4, padd);
stat.setString(5, pcity);
stat.setString(6, pstate);      
stat.setString(7, pzip);


if(pphone.length() !=10 ){
	JOptionPane.showMessageDialog(null, "Enter Valid Phone Number");
}

else{
	for(int i=0;i<pphone.length();i++){
		if(Character.isLetter(pphone.charAt(i))){
	JOptionPane.showMessageDialog(null, "Enter Valid Phone Number");
	phoneField.setText("");
}
	
}
}

     
 if(pzip.length() != 10 ){
	 
	 JOptionPane.showMessageDialog(null, "Enter Valid Date in DD/MM/YYYY");
	zipField.setText(""); 
 }

	 
if(pub_idField.getText().equals("")  ||  pub_nameField.getText().equals("")   ||  phoneField.getText().equals("")   ||  zipField.getText().equals("") || addressField.getText().equals("")  ||  cityField.getText().equals("") ){
JOptionPane.showMessageDialog(null, "All Fiels Are compulsory");
pub_idField.setEditable(true);
pub_nameField.setEditable(true);
}
	else  {   
	stat.executeUpdate();
	JOptionPane.showMessageDialog(null, "Inserted...");
	pub_idField.setEditable(true);
	pub_nameField.setEditable(true);
	}
     
/*Clear the contents of all the fields*/
     
pub_idField.setText("");
     
pub_nameField.setText("");
     
phoneField.setText("");
     
//addressField.setText("vvgfgyg");
     
cityField.setText("Age: ");

        
stateField.setText("");
      
  
zipField.setText("");

}
  
catch(Exception e)
    
{
    
System.out.println("Error1 "+e);
    
error.setText("Row cannot be inserted");
    
} 
                       
  
    
}
 


}





public static void main(String args[]) {
  
//Pub p = new Pub ();
  
//p.compshow();
  
}
   
}
