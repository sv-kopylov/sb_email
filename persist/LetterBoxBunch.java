package sb_email.persist;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Сергей on 26.01.2017.
 */
@Entity
public class LetterBoxBunch implements Serializable{

    private long id;
    @ManyToOne
    private PostBox postBox;

    @ManyToOne
    private Letter letter;

    @Temporal (value = TemporalType.TIMESTAMP)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date date;

    private boolean deleted;

    @Enumerated (EnumType.STRING)
    private Relation relation;


    public LetterBoxBunch() {
    }

    public long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public void setId(long id) {
        this.id = id;
    }

    public PostBox getPostBox() {
        return postBox;
    }

    public void setPostBox(PostBox postBox) {
        this.postBox = postBox;
    }

    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
