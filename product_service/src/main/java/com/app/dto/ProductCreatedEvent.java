package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor

public class ProductCreatedEvent {

    private String id;

    private Integer quantity;

    private BigDecimal price;

    private String title;

}
