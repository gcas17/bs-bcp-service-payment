package bcp.bootcamp.bsbcpservicepayment.services.impl;

import bcp.bootcamp.bsbcpservicepayment.entities.ServicePaymentHistory;
import bcp.bootcamp.bsbcpservicepayment.services.ServicePaymentHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ServicePaymentHistoryServiceImpl implements ServicePaymentHistoryService {
    @Override
    public Flux<ServicePaymentHistory> findAll() {
        return null;
    }

    @Override
    public Mono<ServicePaymentHistory> findByClientId(Integer clientId) {
        return null;
    }

    @Override
    public Mono<ServicePaymentHistory> save() {
        return null;
    }
}
