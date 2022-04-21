package bcp.bootcamp.bsbcpservicepayment.routers;

import bcp.bootcamp.bsbcpservicepayment.core.exceptions.GlobalExceptionHandler;
import bcp.bootcamp.bsbcpservicepayment.entities.ServicePayment;
import bcp.bootcamp.bsbcpservicepayment.entities.ServicePaymentHistory;
import bcp.bootcamp.bsbcpservicepayment.handlers.ServicePaymentHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterConfiguration {
    @Bean
    @RouterOperations( {
        @RouterOperation (
            path = "/service-payment",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.GET,
            beanClass = ServicePaymentHandler.class,
            beanMethod = "getServicePayments",
            operation = @Operation(
                summary = "Listar servicios de pago",
                description = "Listar servicios de pago",
                operationId = "getServicePayments",
                responses = {
                    @ApiResponse(responseCode = "200",
                        description = "successful operation",
                        content = @Content(array=@ArraySchema(schema = @Schema(implementation = ServicePayment.class)))),
                    @ApiResponse(
                        responseCode = "404",
                        description = "No se encontró elementos",
                        content = @Content(schema = @Schema(implementation= GlobalExceptionHandler.HttpError.class))
                    )
                },
                parameters = {
                }
            )
        ),
        @RouterOperation (
                path = "/service-payment/history",
                produces = {MediaType.APPLICATION_JSON_VALUE},
                method = RequestMethod.GET,
                beanClass = ServicePaymentHandler.class,
                beanMethod = "getServicePaymentHistory",
                operation = @Operation(
                    summary = "Listar historial de servicios de pago del cliente",
                    description = "Listar historial de servicios de pago del cliente",
                    operationId = "getServicePaymentHistory",
                    responses = {
                        @ApiResponse(responseCode = "200",
                            description = "successful operation",
                            content = @Content(array=@ArraySchema(schema = @Schema(implementation = ServicePaymentHistory.class)))),
                        @ApiResponse(
                            responseCode = "404",
                            description = "No se encontró elementos",
                            content = @Content(schema = @Schema(implementation= GlobalExceptionHandler.HttpError.class))
                        )
                    },
                    parameters = {
                        @Parameter(in = ParameterIn.QUERY, name = "clientId", required = true )
                    }
                )
        ),
        @RouterOperation (
            path = "/service-payment",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.POST,
            beanClass = ServicePaymentHandler.class,
            beanMethod = "saveServicePaymentHistory",
            operation = @Operation(
                summary = "Realizar pago de servicio",
                description="Realizar pago de servicio",
                operationId = "saveServicePaymentHistory",
                responses = {
                    @ApiResponse(
                        responseCode = "200",
                        description = "successful operation",
                        content = @Content(schema = @Schema(implementation = ServicePaymentHistory.class))
                    )
                },
                parameters = {},
                requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = ServicePaymentHistory.class))))
            )
    })
    public RouterFunction<ServerResponse> servicePaymentRoutes(ServicePaymentHandler servicePaymentHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/service-payment"),
                RouterFunctions
                        .route(GET(""), servicePaymentHandler::getServicePayments)
                        .andRoute(GET("/history"), servicePaymentHandler::getServicePaymentHistory)
                        .andRoute(POST("").and(contentType(APPLICATION_JSON)), servicePaymentHandler::saveServicePaymentHistory)
        );
    }
}
