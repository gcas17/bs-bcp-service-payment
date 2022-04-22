package bcp.bootcamp.bsbcpservicepayment.services.impl;

import bcp.bootcamp.bsbcpservicepayment.entities.ServicePayment;
import bcp.bootcamp.bsbcpservicepayment.repositories.ServicePaymentRepository;
import bcp.bootcamp.bsbcpservicepayment.services.ServicePaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class ServicePaymentServiceImpl implements ServicePaymentService {

    @Autowired
    private ServicePaymentRepository servicePaymentRepository;

    @Override
    public Flux<ServicePayment> findAll() {
        return this.servicePaymentRepository.findAll();
    }

    @Override
    public Flux<ServicePayment> findByChannel(String channel) {
        return this.servicePaymentRepository.findByChannel(channel);
    }
}
