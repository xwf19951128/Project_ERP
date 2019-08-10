package com.cskaoyan.mapper.material;

import com.cskaoyan.bean.material.MaterialReceive;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MaterialReceiveMapper {

    @Select("select count(receive_id) from material_receive")
    int countMaterialReceiveCount();

    List<MaterialReceive> listPageMaterialReceives(@Param("limit") int limit, @Param("offset") int offset);

    @Select("select count(receive_id) from material_receive where receive_id like #{like}")
    int countSearchMaterialReceiveCountByReceiveId(@Param("like") String like);

    List<MaterialReceive> listPageSearchMaterialReceivesByReceiveId(@Param("limit") int limit, @Param("offset") int offset, @Param("like") String like);

    @Select("select count(receive_id) from material_receive where material_id like #{like}")
    int countSearchMaterialReceiveCountByMaterialId(@Param("like") String like);

    List<MaterialReceive> listPageSearchMaterialReceivesByMaterialId(@Param("limit") int limit, @Param("offset") int offset, @Param("like") String like);

    @Update("update material_receive set note = #{materialReceive.note} where receive_id = #{materialReceive.receiveId}")
    int updateNoteById(@Param("materialReceive") MaterialReceive materialReceive);
}
