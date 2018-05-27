package dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class ConsultanceRes {

    @ManyToOne(fetch = FetchType.LAZY)
    private Consultance consultance;

    @Basic
    @Column( name = "DESCRIPTION" )
    private String Description;

    public Consultance getConsultance() {
        return consultance;
    }

    public void setConsultance(Consultance consultance) {
        this.consultance = consultance;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
