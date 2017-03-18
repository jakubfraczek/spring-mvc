package pl.sda.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HistoryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENTRY_ID")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK")
    private Book book;
    private Student owner;
    private Date borrowDate;
    private Date returnDate;

}
