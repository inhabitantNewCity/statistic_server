package dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "User")
public class User {

    @Id
    @Basic
    @Column( name = "USER_ID" )
    private Integer id;

    @Basic
    @Column( name = "NAME" )
    private String name;

    @Basic
    @Column( name = "EMAIL" )
    private String eMail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
