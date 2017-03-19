package pl.sda.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
public class Book {

    @Id
    @Column(name = "SIGNATURE")
    @Pattern(regexp = "[A-Z]{3}[/][A-Z-0-9]{4}", message = "Incorrect signature structure")
    private String signature;

    @NotNull(message = "Title name is compulsory")
    @NotBlank(message = "Title name is compulsory")
    @Column(name = "TITLE")
    private String title;

    @NotNull(message = "First name is compulsory")
    @NotBlank(message = "First name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
    @Column(name = "AUTHOR_NAME")
    private String authorName;

    @NotNull(message = "Last name is compulsory")
    @NotBlank(message = "Last name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "Last name has invalid characters")
    @Column(name = "AUTHOR_SURNAME")
    private String authorSurname;

    @NotNull(message = "Publication Year name is compulsory")
    @NotBlank(message = "Publication Year name is compulsory")
    @Column(name = "PUBLICATION_YEAR")
    @Past
    private Date publicationYear;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNER_ID")
    private Student currentOwner;

    @OneToMany(mappedBy = "bookSignature")
    private List<HistoryEntry> historyEntry;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Date publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Student getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(Student currentOwner) {
        this.currentOwner = currentOwner;
    }


    public List<HistoryEntry> getHistoryEntry() {
        return historyEntry;
    }

    public void setHistoryEntry(List<HistoryEntry> historyEntry) {
        this.historyEntry = historyEntry;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }
}
