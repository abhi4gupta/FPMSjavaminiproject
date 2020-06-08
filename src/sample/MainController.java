package sample;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.*;

public class MainController {

	 String url = "jdbc:mysql://localhost:3306/stud";
	 String user = "root";
	 String pass = "Abhi@123";
	 //Signup
	 @FXML
	 private TextField susername;
	@FXML
	private TextField spassword;
	@FXML
	private Label verified;
	@FXML
	private Label updater;
	@FXML
	private ScrollPane arecords;


	// LOGIN
	
	@FXML
	private Label welcomeid;
	 
	@FXML
	private Label status;
	
	@FXML
	private Label showdetails;
	
	@FXML
	private Text textid;

	@FXML
	private TextField txtUsername;
	
	@FXML
	private TextField txtPassword;
	
	// For View Info window
	@FXML
	private TextField student_id;
	
	//For Add To DB
	
	@FXML
	private TextField studentidfield;
	
	@FXML
	private TextField firstnamefield;
	
	@FXML
	private TextField lastnamefield;
	
	@FXML	
	private TextField emailfield;
	
	@FXML	
	private TextField feesfield;
	
	@FXML
	private Label recstatuslabel;;
	
	// UPDATE DB
	@FXML
	private TextField studentidlabel2;
	
    @FXML	
    private TextField firstnamelabel2;

    @FXML	
    private TextField lastnamelabel2;

    @FXML	
    private TextField emaillabel2;

    @FXML	
    private TextField feeslabel2;
    
    @FXML
    private Label loginlabel2;
    
    @FXML
    private ComboBox<String> amountcombo;
    
    @FXML
    private Label synclabel;
        
    @FXML
    private ScrollPane scrollpanelabel;
    
    ObservableList<String> list = FXCollections.observableArrayList("10000","25000","50000","115000");

    public void Login(ActionEvent event) throws Exception{
		String userN = txtUsername.getText();
		String username =  "\""+userN+"\"";
		String cmd = "select * from login where username = "+username+";";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("hello");

			// connection
			Connection conn = DriverManager.getConnection(this.url,this.user,this.pass);

			// statement
			Statement stmt = conn.createStatement();

			// result
			ResultSet rs = stmt.executeQuery(cmd);
			if(rs.next()){
				if(txtPassword.getText().equals(rs.getString("pass"))){
					Stage primaryStage = new Stage();
					Parent root = FXMLLoader.load(getClass().getResource("/sample/Main.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
				}
				else {
					status.setText("Sorry! Login failed successfully.");
				}
			}
			else {
				status.setText("Sorry! Login failed successfully.");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}


//		if((txtUsername.getText().equals("abhi") || txtUsername.getText().equals("admin")) && txtPassword.getText().equals("Abhi@123")){
//			status.setText("Login successful!");
//
//			Stage primaryStage = new Stage();
//			Parent root = FXMLLoader.load(getClass().getResource("/sample/Main.fxml"));
//			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		}
//		else {
//			status.setText("Sorry! Login failed successfully.");
//		}
	}
	public void Signup(ActionEvent event) throws Exception{
    	try{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/sample/Signup.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();}
    	catch(Exception e) {
			System.out.println(e);
		}
    }
	public void OTP(ActionEvent event) throws Exception{
		String userN = susername.getText();
		String username =  "\""+userN+"\"";
		String userP = spassword.getText();
		String password =  "\""+userP+"\"";
		String cmd = "insert into login values ( "+username+","+password+");";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("hello");

			// connection
			Connection conn = DriverManager.getConnection(this.url, this.user, this.pass);
			System.out.println("hello");
			// statement
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(cmd);
			conn.close();

			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/sample/otp.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
    	catch(Exception e){
			System.out.println(e);
		}
    }
	public void verify(ActionEvent event) throws Exception{
		try{
			verified.setText("verified");
		}
		catch (Exception e){
			System.out.println(e);
		}

	}

	public void ViewInfo(ActionEvent event) throws Exception{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/sample/ViewInfo.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void ViewRecord(ActionEvent event) throws Exception {
		
		String s_id = student_id.getText();
		String cmd = "select * from student where id = " + s_id +";";

		
		 try {  
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("hello");
			 
			 // connection
			 Connection conn = DriverManager.getConnection(this.url,this.user,this.pass);
			 System.out.println("hello");
			 // statement
			 Statement stmt = conn.createStatement();
			 System.out.println("kjkh");
			 // result
			 ResultSet rs = stmt.executeQuery(cmd);  
			 
			 String text = "Firstname Lastname Email Fees\n";
			 
			 if(rs.next()) { 
					showdetails.setText("ID: " + rs.getInt("id") + "\nFirst name: " + rs.getString("first_name")+ "\n" + 
			 "Last name: " +rs.getString("last_name") + "\nEmail Address: " + rs.getString("email") + 
			 "\nFees deposited: " +rs.getInt("fees") + "\n");
			 }
			 else
			 {
				 showdetails.setText("Holy crap... We couldn't find that! You sure that's the ID?");
			 }
			 
			 conn.close(); 
		 }
		 
		 catch(Exception e){
			 System.out.println(e);
	     }  

	}
	
	public void ClearRecord(ActionEvent event) throws Exception{
		
		showdetails.setText("");
	}
	
	public void AddInfo(ActionEvent event) throws Exception {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/sample/AddInfo.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void AddToDatabse(ActionEvent event){
		int student_id = Integer.parseInt(studentidfield.getText());
		String fname = firstnamefield.getText();
		String lname = lastnamefield.getText();
		String email = emailfield.getText();
		int fees = Integer.parseInt(feesfield.getText());
		
		 String cmd = "insert into student (id,first_name,last_name,email,fees) values " + 
		 " (" + student_id + ",'" + fname + "','" + lname + "','" + email + "'," + fees +")";
		
			
		 try {  
			 Class.forName("com.mysql.jdbc.Driver");  
			 Connection conn = DriverManager.getConnection(url,user,pass);  
			 Statement stmt = conn.createStatement();  
			 stmt.executeUpdate(cmd);  
			 conn.close(); 
			 recstatuslabel.setText("Record added successfully!");
		 }
		 
		 catch(Exception e){
			 System.out.println(e);
	     }  
	}
	
	public void About(ActionEvent event) throws Exception {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/sample/About.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void UpdateInfo(ActionEvent event) throws Exception{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/sample/UpdateInfo.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();	
		
	}
	
	public void UpdateRecord(ActionEvent event) throws Exception{
		
		int student_id = Integer.parseInt(studentidlabel2.getText());
		String fname = "'" + firstnamelabel2.getText() + "'";
		String lname = "'" + lastnamelabel2.getText()+ "'";
		String email = "'" + emaillabel2.getText()+ "'";
		int fees = Integer.parseInt(feeslabel2.getText());
		
		
		//String cmd = "update student set first_name = " + fname + ",last_name = " + lname + ",email = " + 
		//email + ",fees = " + fees + " where id = " + student_id + ");";
		
		String cmd = "update student set first_name = " + fname + ", last_name = " + lname + ", email = " +
		email + ", fees = " + fees + " where id = " + student_id + ";";
		
		 try {  
			 Class.forName("com.mysql.jdbc.Driver");  
			 Connection conn = DriverManager.getConnection(url,user,pass);  
			 Statement stmt = conn.createStatement();  
			 stmt.executeUpdate(cmd);
			 updater.setText("updated");
			 conn.close(); 

		 }
		 
		 catch(Exception e){
			 System.out.println(e);
	     }  	
	}
	
	public void ManipulateRecord(ActionEvent event) throws Exception{
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/sample/ManipulateInfo.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();	
		
		//amountcombo.setItems(list);
	}
	
	public void SyncInfo(ActionEvent event) throws Exception{
		
		amountcombo.setItems(list);
		amountcombo.setEditable(true);
		synclabel.setText("Synchronization finished successfully.");
	}
	public void Allrecords(ActionEvent event) throws Exception{
		//String cmd = "select * from student group by id,first_name order by id,first_name;";


			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/sample/Arecords.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();


	}
	public void  synchData(ActionEvent event) throws Exception{
		String cmd = "select * from student group by id order by id;";
		try{	Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(cmd);

			String[] line = new String[200];
			int i=0;

			String gautam = "";
			String x="";
			while(rs.next()) {
				line[i] = (rs.getInt("id") + "\t" + rs.getString("first_name")+ "\t" +
						"\t" +rs.getString("last_name") + "\t\t" + rs.getString("email") + "\t" +
						"\t" +rs.getInt("fees"));

				i++;
			};

			for (i=0; i<100; i++){
				if(line[i]!=null){
					gautam = gautam + line[i] + "\n";
				}
			}

			Text text = new Text(gautam);
			System.out.println("jgfhg");
			arecords.setContent(text);
			System.out.println("jhjhj");
			//conn.close();
		}


		catch(Exception e){
			System.out.println(e);
		}

	}
	public void ComboChanged(ActionEvent event) throws Exception{
		int amount = Integer.parseInt(amountcombo.getValue());
	
		 String cmd = "select * from student where fees >= " + amount +";";
		
			
		 try {  
			 Class.forName("com.mysql.jdbc.Driver");  
			 Connection conn = DriverManager.getConnection(url,user,pass);  
			 Statement stmt = conn.createStatement();  
			 ResultSet rs = stmt.executeQuery(cmd);  
			 
			 String[] line = new String[200];
			 int i=0;
			 
			 String gautam = "";
			 String x="";
				 while(rs.next()) {
				 
				   line[i] = (rs.getInt("id") + "\t" + rs.getString("first_name")+ "\t" + 
			 "\t" +rs.getString("last_name") + "\t\t" + rs.getString("email") + "\t" + 
			 "\t" +rs.getInt("fees"));

			      i++;
				 };
				 
				 for (i=0; i<100; i++){
					 if(line[i]!=null){
				 	  gautam = gautam + line[i] + "\n";
					 }
				 }
				 
				 Text text = new Text(gautam);
				 scrollpanelabel.setContent(text);
			 conn.close(); 
		 }					 
		 
		 catch(Exception e){
			 System.out.println(e);
	     }  
	}		
}