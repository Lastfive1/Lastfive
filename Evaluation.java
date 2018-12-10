
public class Evaluation {
	private String Course_Code1;
	private String Assignment_Name;
	private String Assignment_Type;
	private String KU;
	private String APP;
	private String TI;
	private String COMM;
	private String Weight;
	public String getCourse_code1() {
		return Course_Code1;
	}
	public void setCourse_code1(String course_code1) {
		this.Course_Code1 = course_code1;
	}
	public String getAssignment_Name() {
		return Assignment_Name;
	}
	public void setAssignment_Name(String assignment_Name) {
		this.Assignment_Name = assignment_Name;
	}
	public String getAssignment_Type() {
		return Assignment_Type;
	}
	public void setAssignment_Type(String assignment_Type) {
		this.Assignment_Type = assignment_Type;
	}
	public String getKU() {
		return KU;
	}
	public void setKU(String kU) {
		this.KU = kU;
	}
	public String getAPP() {
		return APP;
	}
	public void setAPP(String aPP) {
		this.APP = aPP;
	}
	public String getTI() {
		return TI;
	}
	public void setTI(String tI) {
		this.TI = tI;
	}
	public String getCOMM() {
		return COMM;
	}
	public void setCOMM(String cOMM) {
		this.COMM = cOMM;
	}
	public String getWeight() {
		return Weight;
	}
	public void setWeight(String weight) {
		this.Weight = weight;
	}

	
	public String toString()
	{
		String result = "Course code: " + Course_Code1 + "\n";
		result += "Assignment Name: " + Assignment_Name + "\n";
		result += "Assignment Type: " + Assignment_Type + "\n";
		result += "Knowledge: " + KU + " " + "Application: " +  APP + " " + "Tech: " + TI + " " + "Communication: " + COMM + "\n"; 
		result += "Weight: " + Weight + "\n";		
		return result;
	}
}
