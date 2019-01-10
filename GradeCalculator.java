
import java.text.DecimalFormat;
import java.util.Scanner;

public class GradeCalculator {
	
	//variables
	private double test;  
	private double assignment;  
	private double lab;  
	private double midterm;
	private double finalExam;    
	private double theory;  
	private double practical;  
	private double finalGrade;
	private String grade;

	Scanner input = new Scanner(System.in);
	DecimalFormat form = new DecimalFormat("#0.##");

	public GradeCalculator() {   //DEFAULT

		test = 0;
		assignment = 0;
		lab = 0;
		midterm = 0;
		finalExam = 0;
		practical = 0;
		theory = 0;
		finalGrade = 0; 

	}
	
	//get value within range
	public double getProperValue(String prompt, double maxValue) {

		double g = input.nextDouble();

		while (g<0 || g>maxValue) {
			System.out.print(prompt);
			g = input.nextDouble();
		}
		return g;
	}

	//input marks
	public void getMarks() { 

		System.out.println("Welcome to the CST8215 Final Mark Calculator");

		System.out.print("\nEnter your Lab exam mark of 10: ");
		lab = getProperValue("Lab mark between 0 and 10: ", 10);

		System.out.print("Enter your Quiz/Test mark out of 10: ");
		test = getProperValue("Quiz mark between 0 and 10: ", 10);

		System.out.print("Enter your Assignements mark out of 20: ");
		assignment = getProperValue("Assignment mark between 0 and 20: ", 20); 

		System.out.print("Enter your Midterm mark out of 20: ");
		midterm = getProperValue("Midterm mark between 0 and 20: ", 20);

		System.out.print("Enter your Final exam mark of 40: ");
		finalExam = getProperValue("Final exam mark between 0 and 40: ", 40);

	}
	
	//display grades
	public void displayGrades() {

		System.out.println ("\nTheory grade: " + form.format(theory) + "%");
		System.out.println("Practical grade: " + form.format(practical) + "%");

		if (theory < 50 && theory < practical) { 
			System.out.println("Final Grade: " + form.format(theory) + "%");	}

		else if (practical < 50 && practical < theory) {
			System.out.println("Final Grade: " + form.format(practical) + "%");	}

		else if (theory > 50 && practical > 50) { 
			System.out.println("Final Grade: " + form.format(finalGrade) + "%"); }

		if (finalGrade < 50) {
			System.out.println("Grade letter: F");
		}
		else {
			System.out.println("Grade letter: " + grade  );
		}

	}
	
	//calculate grades
	public void calculateGrades() {

		theory = ( (test + midterm + finalExam) / 70 *100 );

		practical = ( ( lab + assignment ) /30 * 100 );

		finalGrade = ( test + midterm + finalExam + lab + assignment );

		if (finalGrade <= 100 && finalGrade >= 90) {
			grade = "A+"; }

		else if ( finalGrade >= 85 && finalGrade <= 89) {
			grade = "A"; }

		else if ( finalGrade >= 80 && finalGrade <= 84) {
			grade = "A-";		}

		else if ( finalGrade >= 77 && finalGrade <= 79) {
			grade = "B+";		}

		else if ( finalGrade >= 73 && finalGrade <= 76) {
			grade = "B";		}

		else if ( finalGrade >= 70 && finalGrade <= 72) {
			grade = "B-";		}

		else if (finalGrade >= 67 && finalGrade <= 69) {
			grade = "C+";		}

		else if ( finalGrade >= 63 && finalGrade <= 66) {
			grade = "C";		}

		else if ( finalGrade >= 60 && finalGrade <= 62) {
			grade = "C-";		}

		else if ( finalGrade >= 0 && finalGrade <= 59) {
			grade = "F";		}

	}

}
