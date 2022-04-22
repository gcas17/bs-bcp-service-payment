package bcp.bootcamp.bsbcpservicepayment.services.impl;

import bcp.bootcamp.bsbcpservicepayment.core.exceptions.ServicePaymentBaseException;
import bcp.bootcamp.bsbcpservicepayment.entities.ServicePaymentHistory;
import bcp.bootcamp.bsbcpservicepayment.repositories.ServicePaymentHistoryRepository;
import bcp.bootcamp.bsbcpservicepayment.repositories.ServicePaymentRepository;
import bcp.bootcamp.bsbcpservicepayment.services.ServicePaymentHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ServicePaymentHistoryServiceImpl implements ServicePaymentHistoryService {

    @Autowired
    private ServicePaymentHistoryRepository servicePaymentHistoryRepository;

    @Autowired
    private ServicePaymentRepository servicePaymentRepository;

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

        return this.servicePaymentRepository.findById(servicePaymentHistory.getServicePaymentId())
                .onErrorResume(e -> Mono.empty())
                .switchIfEmpty(Mono.error(new ServicePaymentBaseException(HttpStatus.NOT_FOUND, "Servicio de pago no encontrado")))
                .flatMap(
                    servicePayment -> {
                        servicePaymentHistory.setServicePaymentName(servicePayment.getName());
                        return this.servicePaymentHistoryRepository.save(servicePaymentHistory);
                    }
                );
    }

}
