package com;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private List<String> educationHistory;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.educationHistory = new ArrayList<>();
    }

    public void addEducation(String institution, String degree, LocalDate startDate, LocalDate endDate) {
        educationHistory.add(String.format("Institution: %s, Degree: %s, Start Date: %s, End Date: %s%n", institution, degree, startDate, endDate));
    }

    public void displayStudentRecord() {
        System.out.println("Student Personal Details:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Email: " + email);
        System.out.println("\nStudent Education History:");
        for (String entry : educationHistory) {
            System.out.println(entry);
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your date of birth (yyyy-mm-dd): ");
        String dateOfBirthInput = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthInput, DateTimeFormatter.ISO_DATE);

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        Student student = new Student(firstName, lastName, dateOfBirth, email);

        student.addEducation("University of XYZ", "Bachelor of Science", LocalDate.of(2008, 8, 1), LocalDate.of(2012, 5, 15));
        student.addEducation("School of ABC", "High School Diploma", LocalDate.of(2004, 8, 1), LocalDate.of(2008, 5, 15));

        student.displayStudentRecord();
    }
}