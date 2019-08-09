package com.cskaoyan.mapper.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.Product;

import java.util.List;

public interface ProductMapper_hjc {

    // 通过产品id查询产品名称
    List<Product> queryProduct();
}
