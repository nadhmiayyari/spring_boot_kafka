package com.app.service;


import com.app.rest.ProductDto;

import java.util.concurrent.ExecutionException;

public interface IProductService {

    String createProduct(ProductDto productDto) throws ExecutionException, InterruptedException;
}
