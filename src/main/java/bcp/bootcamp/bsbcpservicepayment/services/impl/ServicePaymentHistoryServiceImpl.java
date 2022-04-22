package bcp.bootcamp.bsbcpservicepayment.services.impl;

import bcp.bootcamp.bsbcpservicepayment.entities.ServicePaymentHistory;
import bcp.bootcamp.bsbcpservicepayment.repositories.ServicePaymentHistoryRepository;
import bcp.bootcamp.bsbcpservicepayment.services.ServicePaymentHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ServicePaymentHistoryServiceImpl implements ServicePaymentHistoryService {

    @Autowired
    private ServicePaymentHistoryRepository servicePaymentHistoryRepository;

    @Override
    public Flux<ServicePaymentHistory> findAll() {
        return this.servicePaymentHistoryRepository.findAll();
    }

    @Override
    public Flux<ServicePaymentHistory> findByClientId(Integer clientId) {
        return this.servicePaymentHistoryRepository.findByClientId(clientId);
    }

    @Override
    public Mono<ServicePaymentHistory> save(ServicePaymentHistory servicePaymentHistory) {
        return this.servicePaymentHistoryRepository.save(servicePaymentHistory);
    }

}
