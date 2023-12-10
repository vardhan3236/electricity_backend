package com.electricity.chartingservice.repository;

import com.electricity.chartingservice.dto.ConnectionChartDataDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "connection-service", url = "${connection-service.url}") // Name of the connection service

public interface ConnectionServiceFeignClient {
    @GetMapping("/api/connections/count")
    List<ConnectionChartDataDTO> getConnectionCount(@RequestParam("status") String status);
}
