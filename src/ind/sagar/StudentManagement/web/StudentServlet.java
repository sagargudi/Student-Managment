package ind.sagar.StudentManagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ind.sagar.StudentManagement.dao.StudentDAO;
import ind.sagar.StudentManagement.model.Student;

/** 
 * Servlet implementation class StudentServlet
 */
@WebServlet(description = "mapping", urlPatterns = { "/" })
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private StudentDAO studentDAO; 
   
   public void init() {
	   this.studentDAO=new StudentDAO();
   }
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
   
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String action=request.getServletPath();
	 switch(action) {
	case "/new":
		showForm(request,response);
		
	break;
	case "/insert":
		insertStudent(request,response);
		
	break;
	case "/delete":
		try {
			deleteStudent(request,response);
			break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	case "/edit":
		
		try {
			editform(request,response);
			break;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	
	case "/update":
		 try {
			updateStudent(request,response);
			break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	default:
		try {
			listStudent(request,response);
			break;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
 }
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List< Student > studentList=studentDAO.selectAllStudent();
		request.setAttribute("studentname", studentList);
		RequestDispatcher rd=request.getRequestDispatcher("Student-list.jsp");
		rd.forward(request, response);
		
	}
	
	private  void showForm(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("student_form.jsp");
		rd.forward(request,response);
	}
	
	private void insertStudent(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		String sname=request.getParameter("sname");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		Student newStudent=new Student(sname,email,address);
		studentDAO.insertStudent(newStudent);
		response.sendRedirect("list");
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int usn =Integer.parseInt(request.getParameter("usn"));
		studentDAO.deleteStudent(usn);
		response.sendRedirect("list");
		
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int usn =Integer.parseInt(request.getParameter("usn"));
		String sname=request.getParameter("sname");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		Student upstu=new Student(usn,sname,email,address);
		studentDAO.updateStudent(upstu);
		response.sendRedirect("list");
	}
	
	private  void editform(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		int usn=Integer.parseInt(request.getParameter("usn"));
		Student presentStudent=studentDAO.selectStudent(usn);
		RequestDispatcher rd=request.getRequestDispatcher("student_form.jsp");
		request.setAttribute("student",presentStudent);
		rd.forward(request, response);	
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
