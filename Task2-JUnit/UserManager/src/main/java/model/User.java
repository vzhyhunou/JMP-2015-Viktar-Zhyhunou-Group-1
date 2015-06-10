package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Natallia_Rakitskaya on 09.06.2015.
 */

@Entity
@Table
public class User {
    @Id
    @Column
    private int id;
    @Column
    private String login;

    public User(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
