import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Grader {
	private ArrayList<Student> student1;
	public static void main(String[] args) throws FileNotFoundException {
		Grader grader = new Grader();
		grader.loadStudents("src/Students.csv");
		System.out.println(grader.getStudents());

	}
	public Grader()
	{
		student1 = new ArrayList<Student>();
	}
	
	public void loadStudents(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		scan.nextLine();
		while(scan.hasNextLine())
		{
			String s = scan.nextLine();
			String[] fields = s.split(",");
			Student student = new Student();
			student.setFirstName(fields[0]);
			student.setLastName(fields[1]);
			student.setStudentNumber(fields[2]);
			student.setPhoneNumber(fields[3]);
			for(int i=0; i<Student.Num_Courses;i++) {
				student.setCourses(fields[i +Student.Num_Courses ]);
			}
			student1.add(student);
		}
	}
	public String getStudents()
	{
		String result = "";
		for(int i =0; i<student1.size();i++) {
			result += student1.get(i) + "\n";
		}
		return result;
	}
}