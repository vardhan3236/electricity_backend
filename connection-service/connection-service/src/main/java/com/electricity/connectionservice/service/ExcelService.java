package com.electricity.connectionservice.service;

import com.electricity.connectionservice.model.Connection;
import com.electricity.connectionservice.repository.ConnectionRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;

@Service
public class ExcelService {

    private final ConnectionRepository connectionRepository;

    @Autowired
    public ExcelService(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    public void importData(InputStream excelFile) throws CsvValidationException {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d-M-yy");
        try (CSVReader reader = new CSVReader(new InputStreamReader(excelFile))) {
            String[] nextLine;
            reader.readNext(); // Skip header row

            while ((nextLine = reader.readNext()) != null) {
                Connection connection = new Connection();

                connection.setId(Long.parseLong(nextLine[0]));
                connection.setApplicantName(nextLine[1]);
                connection.setGender(nextLine[2]);
                connection.setDistrict(nextLine[3]);
                connection.setState(nextLine[4]);
                connection.setPincode(nextLine[5]);
                connection.setOwnership(nextLine[6]);
                connection.setGovtIdType(nextLine[7]);
                connection.setIdNumber(nextLine[8]);
                connection.setCategory(nextLine[9]);
                connection.setLoadApplied(Integer.parseInt(nextLine[10]));

                if (!nextLine[11].isEmpty()) {
                    connection.setDateOfApplication(LocalDate.parse(nextLine[11], dateFormatter));
                }

                if (!nextLine[12].isEmpty()) {
                    connection.setDateOfApproval(LocalDate.parse(nextLine[12], dateFormatter));
                }

                connection.setModifiedDate(LocalDate.parse(nextLine[13], dateFormatter));
                connection.setStatus(nextLine[14]);
                connection.setReviewerId(Integer.parseInt(nextLine[15]));
                connection.setReviewerName(nextLine[16]);
                connection.setReviewerComments(nextLine[17]);

                connectionRepository.save(connection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
