package bcp.bootcamp.bsbcpservicepayment.repositories;

import bcp.bootcamp.bsbcpservicepayment.entities.ServicePaymentHistory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ServicePaymentHistoryRepository extends ReactiveCrudRepository<ServicePaymentHistory, Integer> {

    Flux<ServicePaymentHistory> findByClientId(Integer clientId);

}
