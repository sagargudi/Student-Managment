package ind.sagar.StudentManagement.model;

public class Student {
	private int usn;
	private String sname;
	private String email;
	private String address;
	

	public Student(int usn, String sname, String email, String address) {
		super();
		this.usn = usn;
		this.sname = sname;
		this.email = email;
		this.address = address;
	}

	public Student( String sname, String email, String address) {
		super();
	
		this.sname = sname;
		this.email = email;
		this.address = address;
	}
	

	
	public int getUsn() {
		return usn;
	}
	public void setUsn(int usn) {
		this.usn = usn;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
