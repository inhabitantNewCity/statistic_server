package dao;

import javax.persistence.*;
import java.util.Date;

public class Consultance {

    @Id
    @Basic
    @Column( name = "CONSULTANCE_ID" )
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column( name = "TIME_START" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column( name = "TIME_END" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column( name = "ISACCEPTED" )
    private Boolean isAccepted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
