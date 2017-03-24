package pl.sda.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HistoryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHECKED_ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK")
    private Book book;

    @Column(name = "OWNER")
    private String studentLogin;

    @Column(name = "CHECKED_DATE")
    private Date checkedDate;

    @Column(name = "RETURN_DATE")
    private Date returnDate;

}
