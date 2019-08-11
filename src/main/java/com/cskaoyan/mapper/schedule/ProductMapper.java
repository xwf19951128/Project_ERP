package com.cskaoyan.mapper.schedule;

import com.cskaoyan.bean.schedule.Custom;
import com.cskaoyan.bean.schedule.Product;
import com.cskaoyan.bean.schedule.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    List<Product> queryList();

    List<Product> searchProductListByType(@Param("value") String s);

    List<Product> searchProductListByName(@Param("value")String s);

    List<Product> searchProductListByID(@Param("value")String s);
}