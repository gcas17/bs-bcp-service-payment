package bcp.bootcamp.bsbcpservicepayment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Api BS Service Payment V1.0.0", version = "1.0", description = "Api de negocio para el pago de servicios BCP"))
public class ServicePaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePaymentApplication.class, args);
	}

}
