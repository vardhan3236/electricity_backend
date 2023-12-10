package com.electricity.connectionservice.controller;

import com.electricity.connectionservice.dto.ConnectionChartDataDTO;
import com.electricity.connectionservice.dto.ConnectionDTO;
import com.electricity.connectionservice.dto.ConnectionUpdateDTO;
import com.electricity.connectionservice.model.Connection;
import com.electricity.connectionservice.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/connections")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.PATCH,  RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}, allowCredentials = "true")
public class ConnectionController {

    private final ConnectionService connectionService;

    @Autowired
    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @GetMapping
    public ResponseEntity<List<ConnectionDTO>> getAllConnections() {
        List<ConnectionDTO> connections = connectionService.getAllConnections();
        return new ResponseEntity<>(connections, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateConnection(@PathVariable Long id, @RequestBody ConnectionUpdateDTO updateDTO) {
        // Checking if the connection with the given ID exists
        Optional<Connection> existingConnection = connectionService.findById(id);
        if (existingConnection.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Connection connection = existingConnection.get();
        // Applying restrictions on fields that should not be updated
        updateDTO.setDateOfApplication(connection.getDateOfApplication());
        updateDTO.setGovtIdType(connection.getGovtIdType());
        updateDTO.setIdNumber(connection.getIdNumber());

        // Performing the update
        connectionService.updateConnection(id, updateDTO);

        return ResponseEntity.ok("Connection updated successfully");
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ConnectionDTO>> filterConnectionsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<ConnectionDTO> filteredConnections = connectionService.filterConnectionsByDateRange(startDate, endDate);
        return ResponseEntity.ok(filteredConnections);
    }

    @GetMapping("/search")
    public ResponseEntity<ConnectionDTO> searchConnectionByApplicationId(@RequestParam String applicationId) {
        ConnectionDTO connectionDTO = connectionService.findConnectionByApplicationId(applicationId);
        if (connectionDTO != null) {
            return ResponseEntity.ok(connectionDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/count")
    public ResponseEntity<List<ConnectionChartDataDTO>> getConnectionCount(@RequestParam String status) {
        List<ConnectionChartDataDTO> connections = connectionService.getChartData(status);
        return new ResponseEntity<>(connections, HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteRow(@PathVariable Long id) {
        Optional<Connection> existingConnection = connectionService.findById(id);

        if (existingConnection.isPresent()) {
            connectionService.delete(id);
            return new ResponseEntity<>("Row deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Row not found.", HttpStatus.NOT_FOUND);
        }
    }

}
