import java.util.ArrayList;

public class Student {
	private String FirstName;
	private String LastName;
	private String StudentNumber;
	private String PhoneNumber;
	private ArrayList<String> Courses;
public Student(){
Courses = new ArrayList<String>();
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	this.FirstName = firstName;
}


public String getLastName() {
	return LastName;
}


public void setLastName(String lastName) {
	this.LastName = lastName;
}


public String getStudentNumber() {
	return StudentNumber;
}


public void setStudentNumber(String studentNumber) {
	this.StudentNumber = studentNumber;
}


public String getPhoneNumber() {
	return PhoneNumber;
}


public void setPhoneNumber(String phoneNumber) {
	this.PhoneNumber = phoneNumber;
}


public String getCourses(int i) {
	return Courses.get(i);
}


public void setCourses(String courses) {
	this.Courses.add(courses);

}
public String toString()
{
	String result = FirstName + " " + LastName + "\n";
	result += "Student No:" + StudentNumber + "\n";
	result += "Phone No:" + PhoneNumber + "\n";
	for (int i = 0; i< Courses.size();i++) {
		result += Courses.get(i) + "\n";
	}
	return result;
}
}



