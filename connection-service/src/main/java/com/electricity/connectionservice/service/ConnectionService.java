package com.electricity.connectionservice.service;

import com.electricity.connectionservice.dto.ConnectionChartDataDTO;
import com.electricity.connectionservice.dto.ConnectionDTO;
import com.electricity.connectionservice.dto.ConnectionUpdateDTO;
import com.electricity.connectionservice.model.Connection;
import com.electricity.connectionservice.repository.ConnectionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConnectionService {

    private final ConnectionRepository connectionRepository;

    @Autowired
    public ConnectionService(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    public List<ConnectionDTO> getAllConnections() {
        List<Connection> connections = connectionRepository.findAll();
        return connections.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ConnectionDTO convertToDTO(Connection connection) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(connection, ConnectionDTO.class);
    }


    public Optional<Connection> findById(Long id) {
        return connectionRepository.findById(id);
    }
    public void updateConnection(Long id, ConnectionUpdateDTO updateDTO) {
        // Retrieving the existing connection from the database
        Connection existingConnection = connectionRepository.findById(id).orElse(null);

        if (existingConnection != null) {
            // Updating fields that are allowed to be modified

            existingConnection.setApplicantName(updateDTO.getApplicantName());
            existingConnection.setGender(updateDTO.getGender());
            existingConnection.setDistrict(updateDTO.getDistrict());
            existingConnection.setState(updateDTO.getState());
            existingConnection.setPincode(updateDTO.getPincode());
            existingConnection.setOwnership(updateDTO.getOwnership());
            existingConnection.setCategory(updateDTO.getCategory());
            existingConnection.setLoadApplied(updateDTO.getLoadApplied());
            existingConnection.setDateOfApproval(updateDTO.getDateOfApproval());
            existingConnection.setModifiedDate(updateDTO.getModifiedDate());
            existingConnection.setStatus(updateDTO.getStatus());
            existingConnection.setReviewerId(updateDTO.getReviewerId());
            existingConnection.setReviewerName(updateDTO.getReviewerName());
            existingConnection.setReviewerComments(updateDTO.getReviewerComments());


            // Updating other fields as needed

            // Saving the updated entity
            connectionRepository.save(existingConnection);
        }
    }


    public List<ConnectionDTO> filterConnectionsByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Connection> connections = connectionRepository.findByDateOfApplicationBetween(startDate, endDate);
        return mapConnectionsToDTOs(connections);
    }

    public ConnectionDTO findConnectionByApplicationId(String applicationId) {
        Optional<Connection> connection = connectionRepository.findByIdNumber(applicationId);
        return connection.map(this::mapConnectionToDTO).orElse(null);
    }

    public void delete(Long id) {
        connectionRepository.deleteById(id);
    }

    private List<ConnectionDTO> mapConnectionsToDTOs(List<Connection> connections) {
        return connections.stream()
                .map(this::mapConnectionToDTO)
                .collect(Collectors.toList());
    }

    private ConnectionDTO mapConnectionToDTO(Connection connection) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(connection, ConnectionDTO.class);
    }

    public List<ConnectionChartDataDTO> getChartData(String status) {
        // Implementing the logic to fetch and process data from the repository
        // For example, use connectionRepository.findByStatusAndGroupByMonth(status);

        // Returning the processed data as a list of DTOs
        List<ConnectionChartDataDTO> connections = connectionRepository.findByStatusAndGroupByMonth(status);
        return connections.stream()
                .map(this::convertToChartDTO)
                .collect(Collectors.toList());
    }

    private ConnectionChartDataDTO convertToChartDTO( ConnectionChartDataDTO connection) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(connection, ConnectionChartDataDTO.class);
    }
}