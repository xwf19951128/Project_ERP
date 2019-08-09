package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.Product;
import com.cskaoyan.mapper.qualifyMonitor.ProductMapper_hjc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper_hjc productMapperHjc;

    @Override
    public List<Product> queryProduct() {
        return productMapperHjc.queryProduct();
    }
}
