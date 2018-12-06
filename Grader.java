import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Grader {
	private ArrayList<Students> student;
	public static void main(String[] args) throws FileNotFoundException {
		Grader grader = new Grader();
		grader.loadStudents("File/Students.csv");
		System.out.println(grader);

	}
	public Grader()
	{
		student = new ArrayList<Students>();
	}
	
	public void loadStudents(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		scan.nextLine();
		while(scan.hasNextLine())
		{
			String s = scan.nextLine();
			String[] feilds = s.split(",");
			Students Student = new Students();
			Student.setFirstName(feilds[0]);
			Student.setLastName(feilds[1]);
			for(int i=0; i<4;i++) {
				Student.setCourses(feilds[4+i]);
			}
			student.add(Student);
		}
	}
	public String getStudents()
	{
		String result = "";
		for(int i =0; i<student.size();i++) {
			result += student.get(i) + "\n";
		}
		return result;
	}
}
