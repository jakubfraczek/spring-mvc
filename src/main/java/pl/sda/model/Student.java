package pl.sda.model;


import org.hibernate.annotations.Generated;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private Integer id;

    @NotNull(message = "Login name is compulsory")
    @NotBlank(message = "Login name is compulsory")
    @Size(min = 2, max = 30, message = "Login is too short or too long")
    @Column (name = "LOGIN", unique = true)
    private String login;

    @NotNull(message = "First name is compulsory")
    @NotBlank(message = "First name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
    @Column(name = "FIRST_NAME" )
    private String firstName;

    @NotNull(message = "Last name is compulsory")
    @NotBlank(message = "Last name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "Last name has invalid characters")
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull(message = "Index number is compulsory")
    @Min(value = 10000000, message = "Index number is too short")
    @Max(value = 99999999, message = "Index number is too long")
    @Column(name = "INDEX_NUMBER", unique = true)
    private int indexNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "SPECIALISATION")
    private Specialisation specialisation;

    @OneToMany(mappedBy = "currentOwner")
    private List<Book> books;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
