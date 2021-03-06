package bcp.bootcamp.bsbcpservicepayment.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("service_payment")
public class ServicePayment {
    @Id
    @Column("Id")
    private Integer id;

    @Column("Name")
    private String name;

    @Column("Channel")
    private String channel;

    @Column("CreationDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate creationDate;

    @Column("Status")
    private String status;
}
