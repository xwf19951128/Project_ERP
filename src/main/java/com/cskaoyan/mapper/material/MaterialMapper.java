package com.cskaoyan.mapper.material;

import com.cskaoyan.bean.material.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialMapper {

    List<Material> listMaterials();

    int countMaterialCount();

    List<Material> listPageMaterials(@Param("limit") int limit, @Param("offset") int offset);

}
