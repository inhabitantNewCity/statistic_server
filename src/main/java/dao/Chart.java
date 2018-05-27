package dao;

import javax.persistence.*;

@Entity(name = "LEB_CHART")
public class Chart {

    @Column( name = "CONSULTANCE_ID" )
    private Consultance consultance;

    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Consultance getConsultance() {
        return consultance;
    }

    public void setConsultance(Consultance consultance) {
        this.consultance = consultance;
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
