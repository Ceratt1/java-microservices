package com.ceratti.order_service.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Setter
@Getter
public class Order extends BaseEntity {
	

    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderLineItems> orderLines;

}
