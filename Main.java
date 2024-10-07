import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
	class Subject {
    int subjectMarks, credits, grade;

    void calculateGrade() {
        if (subjectMarks < 40) {
            grade = 0;
        } else {
            grade = subjectMarks / 10 + 1;
        }
    }
}

class Student {
    String name;
    String usn;
    double SGPA;
    Subject subject[];
    Scanner s;

    Student() {
        subject = new Subject[8];
        for (int i = 0; i < 8; i++) {
            subject[i] = new Subject();
        }
        s = new Scanner(System.in);
    }

    void getStudentDetails() {
        System.out.print("Enter student name: ");
        name = s.nextLine();
        System.out.print("Enter USN: ");
        usn = s.nextLine();
    }

    void getMarks() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Enter marks for Subject " + (i + 1) + ": ");
            subject[i].subjectMarks = s.nextInt();
            System.out.println("Enter credits for Subject " + (i + 1) + ": ");
            subject[i].credits = s.nextInt();

            subject[i].calculateGrade();
            if (subject[i].subjectMarks > 100) {
                System.out.println("Marks should not exceed 100");
            }
        }
    }

    void computeSGPA() {
        int totalCredits = 0, totalPoints = 0;

        for (int i = 0; i < 8; i++) {
            totalCredits += subject[i].credits;
            totalPoints += subject[i].grade*subject[i].credits;
        }

        SGPA = (double)totalPoints/totalCredits;
    }

    void displayResult() {
        System.out.println("Student Name: " + name);
        System.out.println("USN: " + usn);
        System.out.println("SGPA: " + SGPA);
    }
}

        Student s1 = new Student();
        s1.getStudentDetails();
        s1.getMarks();
        s1.computeSGPA();
        s1.displayResult();

	System.out.println("KHALID RABBANI" )  ; 
	System.out.print("1BM23CS150") ; 
    }
}


