package com.example.demo.models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "monitored_endpoint")
public class MonitoredEndpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final int id;

    @Column(name = "name", nullable = false, unique = true)
    private final String name;

    @Column(name = "url", nullable = false, unique = true)
    private final String url;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "dateCreation", nullable = false, unique = true)
    private final DateTime dateCreation;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "lastCheck", nullable = false, unique = true)
    private final DateTime lastCheck;

    @Column(name = "monitoredInterval", nullable = false, unique = true)
    private final int monitoredInterval;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private final User owner;

//    @OneToMany(mappedBy = "monitoredEndpoint", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<MonitoringResult> monitoringResults;

    public MonitoredEndpoint(int id, String name, String url, DateTime dateCreation, DateTime lastCheck, int
                             monitoredInterval, User owner) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.dateCreation = dateCreation;
        this.lastCheck = lastCheck;
        this.monitoredInterval = monitoredInterval;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public DateTime getDateCreation() {
        return dateCreation;
    }

    public DateTime getLastCheck() {
        return lastCheck;
    }

    public int getMonitoredInterval() {
        return monitoredInterval;
    }

    public User getOwner() {
        return owner;
    }
}
