package bcp.bootcamp.bsbcpservicepayment.handlers;

import bcp.bootcamp.bsbcpservicepayment.core.exceptions.ServicePaymentBaseException;
import bcp.bootcamp.bsbcpservicepayment.entities.ServicePayment;
import bcp.bootcamp.bsbcpservicepayment.entities.ServicePaymentHistory;
import bcp.bootcamp.bsbcpservicepayment.services.ServicePaymentHistoryService;
import bcp.bootcamp.bsbcpservicepayment.services.ServicePaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        if(request.queryParam("id").isPresent() && request.queryParam("channel").isPresent()) {
            return this.servicePaymentService.findByIdAndChannel(Integer.parseInt(request.queryParam("id").get()), request.queryParam("channel").get())
                .switchIfEmpty(Mono.error(new ServicePaymentBaseException(HttpStatus.NO_CONTENT, "No se encontró elementos")))
                .collectList()
                .flatMap(list -> ServerResponse.ok().body(Mono.just(list), ServicePayment.class));
        }

        if(request.queryParam("servicePaymentId").isEmpty() && request.queryParam("channel").isPresent()) {
            return this.servicePaymentService.findByChannel(request.queryParam("channel").get())
                .switchIfEmpty(Mono.error(new ServicePaymentBaseException(HttpStatus.NO_CONTENT, "No se encontró elementos")))
                .collectList()
                .flatMap(list -> ServerResponse.ok().body(Mono.just(list), ServicePayment.class));
        }

        return this.servicePaymentService.findAll()
                .switchIfEmpty(Mono.error(new ServicePaymentBaseException(HttpStatus.NO_CONTENT, "No se encontró elementos")))
                .collectList()
                .flatMap(list -> ServerResponse.ok().body(Mono.just(list), ServicePayment.class));
    }

    public Mono<ServerResponse> getServicePaymentHistory(ServerRequest request) {
        if(request.queryParam("clientId").isEmpty()) {
            return Mono.error(new ServicePaymentBaseException(HttpStatus.BAD_REQUEST, "QueryParam: 'clientId' es obligatorio."));
        }

        Integer clientId = Integer.parseInt(request.queryParam("clientId").get());

        return this.servicePaymentHistoryService.findByClientId(clientId)
                .switchIfEmpty(Mono.error(new ServicePaymentBaseException(HttpStatus.NO_CONTENT, "No se encontró elementos")))
                .collectList()
                .flatMap(list -> ServerResponse.ok().body(Mono.just(list), ServicePaymentHistory.class));
    }

    public Mono<ServerResponse> saveServicePaymentHistory(ServerRequest request) {
        return request.bodyToMono(ServicePaymentHistory.class)
                .flatMap(servicePaymentHistory -> this.servicePaymentHistoryService.save(servicePaymentHistory))
                .flatMap(servicePaymentHistory -> ServerResponse.ok().body(Mono.just(servicePaymentHistory), ServicePaymentHistory.class));
    }

}
