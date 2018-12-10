
public class Course {
	private String Course_Code;
	private String Course_Name;
	private String Room_Number;

	public String getCourse_Code() {
		return Course_Code;
	}
	public void setCourse_Code(String course_Code) {
		this.Course_Code = course_Code;
	}
	public String getCourse_Name() {
		return Course_Name;
	}
	public void setCourse_Name(String course_Name) {
		this.Course_Name = course_Name;
	}
	public String getRoom_Number() {
		return Room_Number;
	}
	public void setRoom_Number(String room_Number) {
		this.Room_Number = room_Number;
	}
	public String toString()
	{
		String result = "Course Code:" + Course_Code + "\n";
		result += "Course Name:" + Course_Name + "\n";
		result += "Room Number:" + Room_Number + "\n";
		return result;
	}
	}