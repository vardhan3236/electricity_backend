package com.electricity.chartingservice.controller;

import com.electricity.chartingservice.dto.ConnectionChartDataDTO;
import com.electricity.chartingservice.service.ChartingService;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chart")
@CrossOrigin(origins = "http://localhost:4200")
public class ChartingController {

    private final ChartingService chartingService;
    private static final Logger logger = LoggerFactory.getLogger(ChartingController.class);

    @Autowired
    public ChartingController(ChartingService chartingService) {
        this.chartingService = chartingService;
    }

    @GetMapping("/count")
    public ResponseEntity<List<ConnectionChartDataDTO>> getConnectionCount(@RequestParam("status") String status) {
        logger.info("Fetching chart data for status: {}", status);
        List<ConnectionChartDataDTO> count = chartingService.getConnectionCount(status);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }


}
