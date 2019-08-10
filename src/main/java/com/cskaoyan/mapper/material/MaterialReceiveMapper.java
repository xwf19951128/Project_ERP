package com.cskaoyan.mapper.material;

import com.cskaoyan.bean.material.MaterialReceive;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MaterialReceiveMapper {

    @Select("select count(receive_id) from material_receive")
    int countMaterialReceiveCount();

    List<MaterialReceive> listPageMaterialReceives(@Param("limit") int limit, @Param("offset") int offset);
}
