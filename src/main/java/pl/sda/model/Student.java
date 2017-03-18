package pl.sda.model;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;


public class Student {
    @NotNull(message = "Login name is compulsory")
    @NotBlank(message = "Login name is compulsory")
    @Size(min = 2, max = 30, message = "Login is too short or too long")
    private String login;

    @NotNull(message = "First name is compulsory")
    @NotBlank(message = "First name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
    private String firstName;

    @NotNull(message = "Last name is compulsory")
    @NotBlank(message = "Last name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "Last name has invalid characters")
    private String lastName;

    @NotNull(message = "Index number is compulsory")
//    @NotBlank(message = "Index number is compulsory")
//    @Pattern(regexp = "[0-9]*", message = "Index number has invalid characters")
    @Min(value = 10000000, message = "Index number is too short")
    @Max(value = 99999999, message = "Index number is too long")
    private int indexNumber;
    private Gender gender;
    private Specialisation specialisation;

    public Student(String login, String firstName, String lastName, int indexNumber, Gender gender, Specialisation specialisation) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.indexNumber = indexNumber;
        this.gender = gender;
        this.specialisation = specialisation;
    }

    public Student() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Specialisation getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(Specialisation specialisation) {
        this.specialisation = specialisation;
    }
}
