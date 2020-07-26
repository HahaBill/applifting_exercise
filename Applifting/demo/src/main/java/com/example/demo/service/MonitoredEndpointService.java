package com.example.demo.service;

import com.example.demo.models.MonitoredEndpoint;
import com.example.demo.repository.MonitoredEndpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoredEndpointService {

    @Autowired
    private MonitoredEndpointRepository monitoredEndpointRepository;

    public List<MonitoredEndpoint> listAllEndpoints() {
        return monitoredEndpointRepository.findAll();
    }

}
