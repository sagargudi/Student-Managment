package ind.sagar.StudentManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ind.sagar.StudentManagement.model.Student;

public class StudentDAO {
	
	
	
	private	String url="jdbc:mysql://localhost:3306/Student_details";
		private String uname="root";
		private String pass="gudi";
		
		private static final String Insert_student_by_usn="insert into student_infor"+" (sname,email,address)"+" values (?,?,?);";
		 private static final String Select_student_by_id="select usn,sname, email,address from student_infor where usn=?;";
		private static final String Select_Allstudent="select *from student_infor;";
		private static final String Delete_student="delete from student_infor where usn=?;";
		private static final String Update_student="update student_infor set sname=?,email=?,address=? where usn=?;";
		
		

	    public StudentDAO() {}
		//common connection to all the methods(for create ,update and delete)
	protected Connection getConnect() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,uname,pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void updateStudent(Student stu) throws SQLException {
		
		//boolean rowgotUpdated;
		try(Connection con=getConnect();
				PreparedStatement pst=con.prepareStatement(Update_student)){
			
			pst.setString(1, stu.getSname());
			pst.setString(2, stu.getEmail());
			pst.setString(3, stu.getAddress());
			pst.setInt(4, stu.getUsn());
			
			pst.executeUpdate();// if the row count is more than 0 then  return the rowcount
			pst.close();
	        con.close();
		
		} 
		//return rowgotUpdated;
		// select student by ID
	}
		
	
//To insert the data into student_detail table
	public void insertStudent(Student stu) {
		 System.out.println(Insert_student_by_usn);
		try(Connection con=getConnect();
				PreparedStatement pst=con.prepareStatement(Insert_student_by_usn)){
			
			pst.setString(1, stu.getSname());
			pst.setString(2, stu.getEmail());
			pst.setString(3, stu.getAddress());
			 System.out.println(pst);
	         pst.executeUpdate();
	         
	         pst.close();
	        con.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
				
	}
	
	//Update the student data in the form 

		public Student selectStudent(int usn) throws SQLException {
			Student stu=null;
			try(Connection con=getConnect();
					PreparedStatement pst=con.prepareStatement(Select_student_by_id);){
				pst.setInt(1, usn);
				System.out.println(pst);
			ResultSet res=pst.executeQuery();
			while(res.next()) {
			String sname=res.getString("sname");
			String email=res.getString("email");
			String address=res.getString("address");
			  stu=new Student(usn,sname,email,address);
			  
			}
			pst.close();
	        con.close();
			
			
			}
			
			return stu;	
			 
			
		}

		
	
		// select all the students;
		
		public List<Student> selectAllStudent() throws SQLException {
		List<Student> al= new ArrayList<>();
			try(Connection con=getConnect();
					PreparedStatement pst=con.prepareStatement(Select_Allstudent);){
				 System.out.println(pst);
		
			ResultSet res=pst.executeQuery();
			while(res.next()) {
				
			int usn=res.getInt("usn");
			String sname=res.getString("sname");
			String email=res.getString("email");
			String address=res.getString("address");
			 al.add(new Student(usn,sname,email,address));
			 
				
	}
			
			}
			return al;
		}
		
		// deleting the student 
		
		public boolean deleteStudent(int usn) throws SQLException {
			boolean rowgotdeleted;
			try(Connection con=getConnect();
					PreparedStatement pst=con.prepareStatement(Delete_student)){
				pst.setInt(1, usn);
				rowgotdeleted=pst.executeUpdate()>0;
				  pst.close();
			        con.close();
			}
			return rowgotdeleted;
		
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

