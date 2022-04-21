package bcp.bootcamp.bsbcpservicepayment.repositories;

import bcp.bootcamp.bsbcpservicepayment.entities.ServicePaymentHistory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ServicePaymentHistoryRepository extends ReactiveCrudRepository<ServicePaymentHistory, Integer> {
}
