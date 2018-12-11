import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
public class Grader extends Application {
	private ArrayList<Student> studentlist;
	private ArrayList<Course> courselist;
	private ArrayList<Evaluation> evaluationlist;
	private int Num_Courses = 4;
	public static void main(String[] args) throws FileNotFoundException {
		launch(args);
	}
	public Grader()
	{
		evaluationlist = new ArrayList<Evaluation>();
		courselist = new ArrayList<Course>();
		studentlist = new ArrayList<Student>();
	}
	public void start(Stage primarystage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 400, 400);
		Button b1 = new Button("Students");
		Button b2 = new Button("Courses");
		Button b3 = new Button("Evaluation");
		TextField text1 = new TextField();
		text1.setMaxWidth(100);
		text1.setLayoutX(0);
		text1.setLayoutY(35);
		b2.setLayoutX(0);
	    b2.setLayoutY(70);
	    b3.setLayoutX(0);
	    b3.setLayoutY(140);
		b1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				try {
					loadStudents("src/Students.csv");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println(getStudents());	
			}
		});
		b2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				try {
					loadcourses("src/Courses.csv");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println(getCourses());	
			}
		});
		b3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				try {
					loadevaluations("src/Evaluations.csv");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println(getEvaluation());	
			}
		});
		text1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
			Student stu;
			try {
				stu = findStudent(text1.getText());
				System.out.println(stu);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			}	
		});
		root.getChildren().addAll(b1,b2,b3,text1);
		primarystage.setTitle("GUI");
		primarystage.setScene(scene);
		primarystage.show();
	}
	public Student findStudent(String StudentNumber) throws FileNotFoundException {
		for(int i = 0; i< studentlist.size(); i++) {
			if(StudentNumber.equals(studentlist.get(i).getStudentNumber())) {
				return studentlist.get(i);
			}
		}
		return null;
	}
	public void loadStudents(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		scan.nextLine();
		while(scan.hasNextLine())
		{
			String s = scan.nextLine();
			String[] feilds = s.split(",");
			Student S = new Student();
			S.setFirstName(feilds[0]);
			S.setLastName(feilds[1]);
			S.setStudentNumber(feilds[2]);
			S.setPhoneNumber(feilds[3]);
			for(int i=0; i<Num_Courses;i++) {
				S.setCourses(feilds[4+i]);
			}
			studentlist.add(S);
		}
		scan.close();
	}
	public void loadinfo(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		scan.nextLine();
		while(scan.hasNextLine())
		{
			String s = scan.nextLine();
			String[] feilds = s.split(",");
			Student S = new Student();
			S.setFirstName(feilds[0]);
			S.setLastName(feilds[1]);
			S.setStudentNumber(feilds[2]);
			studentlist.add(S);
		}
		scan.close();
	}
	public void loadcourses(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		scan.nextLine();
		while(scan.hasNextLine())
		{
			String s = scan.nextLine();
			String[] feilds = s.split(",");
			Course C = new Course();
			C.setCourse_Code(feilds[0]);
			C.setCourse_Name(feilds[1]);
			C.setRoom_Number(feilds[2]);
			courselist.add(C);
		}
	}
	public void loadevaluations(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		scan.nextLine();
		while(scan.hasNextLine())
		{
			String s = scan.nextLine();
			String[] feilds = s.split(",");
			Evaluation E = new Evaluation();
			E.setCourse_code1(feilds[0]);
			E.setAssignment_Name(feilds[1]);
			E.setAssignment_Type(feilds[2]);
			E.setKU(feilds[3]);
			E.setAPP(feilds[4]);
			E.setTI(feilds[5]);
			E.setCOMM(feilds[6]);
			E.setWeight(feilds[7]);
			evaluationlist.add(E);
		}
	}
	public String getStudents()
	{
		String result = "";
		for(int i =0; i<studentlist.size();i++) {
			result += studentlist.get(i) + "\n";
		}
		return result;
	}
	public String getCourses()
	{
		String result = "";
		for(int i =0; i<courselist.size();i++) {
			result += courselist.get(i) + "\n";
		}
		return result;
	}
	public String getEvaluation()
	{
		String result = "";
		for(int i =0; i<evaluationlist.size();i++) {
			result += evaluationlist.get(i) + "\n";
		}
		return result;
	}
}