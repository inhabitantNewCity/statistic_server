package dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class Message {
    @ManyToOne(fetch = FetchType.LAZY)
    private Chart chart;
    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;

    @Basic
    @Column( name = "TEXT" )
    private String text;
    
}
