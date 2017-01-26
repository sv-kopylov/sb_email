package sb_email.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Сергей on 25.01.2017.
 */
@Entity
public class PostBox implements Serializable {
    private long id;
    private String login;
    private String password;
    private String name;

    public long getId() {
        return id;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
