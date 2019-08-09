package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.Product;

import java.util.List;

public interface ProductService {

    // 通过产品id查询产品名称
    List<Product> queryProduct();
}
