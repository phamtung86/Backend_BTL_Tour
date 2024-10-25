package org.example.Controller;

import org.example.Modal.Transport;
import org.example.Service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TransportController {
    @Autowired
    private TransportService transportService;

    @GetMapping("/transports")
    public List<Transport> ListTransports() {
        return transportService.listAllTransports();
    }
    @GetMapping("/maptransports")
    public Map<Integer, Transport> mapTransport() {
        return transportService.mapTransports();
    }
}
