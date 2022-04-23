package bcp.bootcamp.bsbcpservicepayment.services;

import bcp.bootcamp.bsbcpservicepayment.entities.ServicePayment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServicePaymentService {

    Mono<ServicePayment> findById(Integer id);

    Flux<ServicePayment> findAll();

    Flux<ServicePayment> findByChannel(String channel);

    Flux<ServicePayment> findByIdAndChannel(Integer id, String channel);

}
