package pl.sda.service;

/**
 * Created by Kufra on 23.04.17.
 */
public class BookRentDTO {
    private String studentLogin;
    private String bookSignature;

    public String getStudentLogin() {
        return studentLogin;
    }

    public void setStudentLogin(String studentLogin) {
        this.studentLogin = studentLogin;
    }

    public String getBookSignature() {
        return bookSignature;
    }

    public void setBookSignature(String bookSignature) {
        this.bookSignature = bookSignature;
    }
}
