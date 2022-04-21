package bcp.bootcamp.bsbcpservicepayment.handlers;

import bcp.bootcamp.bsbcpservicepayment.services.ServicePaymentHistoryService;
import bcp.bootcamp.bsbcpservicepayment.services.ServicePaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ServicePaymentHandler {

    @Autowired
    private ServicePaymentService servicePaymentService;

    @Autowired
    private ServicePaymentHistoryService servicePaymentHistoryService;

    public Mono<ServerResponse> getServicePayments(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> getServicePaymentHistory(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> saveServicePaymentHistory(ServerRequest request) {
        return null;
    }

}
