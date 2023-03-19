package AssingmentCorrection;

import java.time.LocalDate;

public class Student{


    private String firstName;
    private String secondName;
    private LocalDate dateOfBirth;
    private String address ;
    private int id;
    private Gender gender;


    public Student(String firstName, String secondName, LocalDate dateOfBirth, String address, int id, Gender gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.id = id;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }
}
