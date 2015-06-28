package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Natallia_Rakitskaya on 09.06.2015.
 */

@Entity
@Table
public class User implements Serializable {
    private static final long serialVersionUID = -5251150757175506026L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "LOGIN")
    private String login;

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
