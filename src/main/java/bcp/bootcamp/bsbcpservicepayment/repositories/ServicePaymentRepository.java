package bcp.bootcamp.bsbcpservicepayment.repositories;

import bcp.bootcamp.bsbcpservicepayment.entities.ServicePayment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ServicePaymentRepository extends ReactiveCrudRepository<ServicePayment, Integer> {

    Flux<ServicePayment> findByChannel(String channel);

}
