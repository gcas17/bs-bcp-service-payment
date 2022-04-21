package bcp.bootcamp.bsbcpservicepayment.services;

import bcp.bootcamp.bsbcpservicepayment.entities.ServicePayment;
import reactor.core.publisher.Flux;

public interface ServicePaymentService {

    Flux<ServicePayment> findAll();

}
