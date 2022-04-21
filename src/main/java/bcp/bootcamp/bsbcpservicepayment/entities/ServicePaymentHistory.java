package bcp.bootcamp.bsbcpservicepayment.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("service_payment_history")
public class ServicePaymentHistory {
    @Id
    @Column("Id")
    private Integer id;

    @Column("ClientId")
    private Integer clientId;

    @Column("ServicePaymentId")
    private Integer servicePaymentId;

    @Column("ServicePaymentName")
    private String servicePaymentName;

    @Column("SupplyNumber")
    private String supplyNumber;

    @Column("Amount")
    private BigDecimal amount;

    @Column("Currency")
    private String currency;

    @Column("TransactionDate")
    private LocalDate transactionDate;
}
