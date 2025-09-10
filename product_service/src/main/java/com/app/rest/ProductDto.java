package com.app.rest;


import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String title;

    private BigDecimal price;

    private Integer quantity;
}
