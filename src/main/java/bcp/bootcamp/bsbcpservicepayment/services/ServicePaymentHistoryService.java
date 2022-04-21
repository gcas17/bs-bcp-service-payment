package bcp.bootcamp.bsbcpservicepayment.services;

import bcp.bootcamp.bsbcpservicepayment.entities.ServicePaymentHistory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServicePaymentHistoryService {

    Flux<ServicePaymentHistory> findAll();

    Mono<ServicePaymentHistory> findByClientId(Integer clientId);

    Mono<ServicePaymentHistory> save(ServicePaymentHistory servicePaymentHistory);

}
