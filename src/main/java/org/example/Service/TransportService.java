package org.example.Service;

import org.example.Modal.Transport;
import org.example.Reponsitory.TransportReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransportService {
    @Autowired
    private TransportReponsitory transportReponsitory;

    public List<Transport> listAllTransports() {
        return transportReponsitory.findAll();
    }

    public Map<Integer, Transport> mapTransports() {
        List<Transport> transports = transportReponsitory.findAll();
        return transports.stream().collect(Collectors.toMap(Transport::getId, transport -> transport));
    }

}
