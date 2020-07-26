package com.example.demo.models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "monitoring_result")
public class MonitoringResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final int id;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "dataCheck", nullable = false, unique = true)
    private final DateTime dateCheck;

    @Column(name = "statusCode", nullable = false, unique = true)
    private final int statusCode;

    @Column(name = "payloadInfo", nullable = false, unique = true)
    private final String payloadInfo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "endpoint_id", nullable = false)
    private final MonitoredEndpoint monitoredEndpoint;

    public MonitoringResult(int id, DateTime dateCheck, int statusCode, String payloadInfo,
                            MonitoredEndpoint monitoredEndpoint) {
        this.id = id;
        this.dateCheck = dateCheck;
        this.statusCode = statusCode;
        this.payloadInfo = payloadInfo;
        this.monitoredEndpoint = monitoredEndpoint;
    }

    public int getId() {
        return id;
    }

    public DateTime getDateCheck() {
        return dateCheck;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getPayloadInfo() {
        return payloadInfo;
    }

    public MonitoredEndpoint getMonitoredEndpoint() {
        return monitoredEndpoint;
    }
}
