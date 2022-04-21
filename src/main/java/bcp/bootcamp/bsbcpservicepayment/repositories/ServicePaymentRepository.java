package bcp.bootcamp.bsbcpservicepayment.repositories;

import bcp.bootcamp.bsbcpservicepayment.entities.ServicePayment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ServicePaymentRepository extends ReactiveCrudRepository<ServicePayment, Integer> {
}
