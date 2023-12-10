package com.electricity.chartingservice.service;

import com.electricity.chartingservice.controller.ChartingController;
import com.electricity.chartingservice.dto.ConnectionChartDataDTO;
import com.electricity.chartingservice.repository.ConnectionServiceFeignClient;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChartingService {

    private final ConnectionServiceFeignClient connectionServiceFeignClient;
    private static final Logger logger = LoggerFactory.getLogger(ChartingController.class);
    @Autowired
    public ChartingService(ConnectionServiceFeignClient connectionServiceFeignClient) {
        this.connectionServiceFeignClient = connectionServiceFeignClient;
    }

    public List<ConnectionChartDataDTO> getConnectionCount(String status) {

        try {
            // Calling the Feign client method
            List<ConnectionChartDataDTO> count =  connectionServiceFeignClient.getConnectionCount(status);
            return count;
        } catch (FeignException e) {
            // Logging the exception for further analysis
            logger.error("FeignException during getConnectionCount: {}", e.contentUTF8(), e);
            throw e;
        }
    }
}
