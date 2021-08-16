package com.epam.training;

import com.epam.training.bean.Student;
import com.epam.training.client.University;

import com.epam.training.constants.FacultyName;
import com.epam.training.constants.GroupNumber;
import com.epam.training.constants.Subject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Runner {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			List<Student> students = getDataFromFile();
			University university = new University(students);
			university.distributeStudentsByFacultiesAndGroups();
			switch (menu()) {
				case 1:
					Student student = chooseStudent(university.getStudents());
					System.out.println("Student: " + student.getFullName());
					System.out.println("Grades: " + student.getGrades());
					System.out.println("Grade average: " + student.getGradeAverage());
					break;

				case 2:
					Subject subject = chooseSubject();
					FacultyName faculty = chooseFaculty();
					GroupNumber group = chooseGroup();
					System.out.println("Grade average for " + subject.name() + " in " +
							group.name() + " group at " + faculty.name() + " faculty: " +
							university.getGradeAverageFor(subject, faculty, group));
					break;

				case 3:
					Subject someSubject = chooseSubject();
					System.out.println("University grade average for " + someSubject.name() +
							": " + university.getGradeAverageFor(someSubject));
					break;

				default:
					throw new IllegalArgumentException("Invalid option");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File with students' data is not found");
		}
	}

	static List<Student> getDataFromFile() throws FileNotFoundException {
		List<Student> students = new ArrayList<>();
		File file = new File("students.txt");
		Scanner fileScanner = new Scanner(file);
		while (fileScanner.hasNext()) {
			String fullName = fileScanner.next() + " " + fileScanner.next();
			FacultyName facultyName = FacultyName.valueOf(fileScanner.next());
			GroupNumber groupNumber = GroupNumber.valueOf(fileScanner.next());
			Map<Subject, Integer> grades = Map.of(
					Subject.valueOf(fileScanner.next()), fileScanner.nextInt(),
					Subject.valueOf(fileScanner.next()), fileScanner.nextInt());
			students.add(new Student(fullName, facultyName, groupNumber, grades));
		}
		return students;
	}

	static int menu() {
		System.out.println("1 - Get student's grade average");
		System.out.println("2 - Get grade average for subject in given group " +
				"at particular faculty");
		System.out.println("3 - Get university grade average for given subject");
		System.out.print("?");
		return scanner.nextInt();
	}

	static Student chooseStudent(List<Student> students) {
		System.out.println("Choose student:");
		for (int i = 0; i < students.size(); i++) {
			System.out.println((i + 1) + ". " + students.get(i));
		}
		System.out.print("?");
		int studentIndex = scanner.nextInt() - 1;
		return students.get(studentIndex);
	}

	static Subject chooseSubject() {
		System.out.println("Choose subject:");
		for (int i = 0; i < Subject.values().length; i++) {
			System.out.println((i + 1) + ". " + Subject.values()[i]);
		}
		System.out.print("?");
		int subjectOrdinal = scanner.nextInt() - 1;
		return Subject.values()[subjectOrdinal];
	}

	static FacultyName chooseFaculty() {
		System.out.println("Choose faculty:");
		for (int i = 0; i < FacultyName.values().length; i++) {
			System.out.println((i + 1) + ". " + FacultyName.values()[i]);
		}
		System.out.print("?");
		int facultyOrdinal = scanner.nextInt() - 1;
		return FacultyName.values()[facultyOrdinal];
	}

	static GroupNumber chooseGroup() {
		System.out.println("Choose group:");
		for (int i = 0; i < GroupNumber.values().length; i++) {
			System.out.println((i + 1) + ". " + GroupNumber.values()[i]);
		}
		System.out.print("?");
		int groupOrdinal = scanner.nextInt() - 1;
		return GroupNumber.values()[groupOrdinal];
	}
}
