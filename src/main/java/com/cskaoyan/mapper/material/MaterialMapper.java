package com.cskaoyan.mapper.material;

import com.cskaoyan.bean.material.Material;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MaterialMapper {

    List<Material> listMaterials();

    int countMaterialCount();


    List<Material> listPageMaterials(@Param("limit") int limit, @Param("offset") int offset);


    int insertMaterial(@Param("material") Material material);

    @Update("update material set note = #{material.note} where material_id = #{material.materialId}")
    int updateNoteById(@Param("material") Material material);

    //@Update("update material set material_type = #{material.materialType}, status = #{material.status}, note = #{material.note} where material_id = #{material.materialId}")
    @Update("update material set material_type = #{materialType}, status = #{status}, remaining = #{remaining}, note = #{note} where material_id = #{materialId}")
    int updateAllById(Material material);

    int deleteMaterialsByIds(@Param("ids") String[] ids);

    @Select("select count(material_id) from material where material_id like #{like}")
    int countSearchMaterialCountById(@Param("like") String like);


    @Select("select material_id as materialId, material_type as materialType, status, remaining, note from material where material_id like #{like} limit #{limit} offset #{offset}")
    List<Material> listPageSearchMaterialsById(@Param("limit") int limit, @Param("offset") int offset, @Param("like") String like);

    @Select("select count(material_id) from material where material_type like #{like}")
    int countSearchMaterialCountByType(@Param("like")String like);

    @Select("select material_id as materialId, material_type as materialType, status, remaining, note from material where material_type like #{like} limit #{limit} offset #{offset}")
    List<Material> listPageSearchMaterialsByType(@Param("limit") int limit, @Param("offset") int offset, @Param("like") String like);
}
