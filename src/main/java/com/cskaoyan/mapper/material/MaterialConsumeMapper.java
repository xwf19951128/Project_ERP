package com.cskaoyan.mapper.material;

import com.cskaoyan.bean.material.MaterialConsume;
import com.cskaoyan.bean.material.MaterialConsumeExample;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface MaterialConsumeMapper {
    long countByExample(MaterialConsumeExample example);

    int deleteByExample(MaterialConsumeExample example);

    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    List<MaterialConsume> selectByExample(MaterialConsumeExample example);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByExampleSelective(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByExample(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);

    List<MaterialConsume> listAllMaterialConsumes();

    List<MaterialConsume> listAllSearchMaterialConsumesByConsumeId(@Param("like") String like);

    List<MaterialConsume> listAllSearchMaterialConsumesByWorkId(String like);

    List<MaterialConsume> listAllSearchMaterialConsumesByMaterialId(String like);

/*    @Insert("insert into material_consume (consume_id, work_id, material_id, consume_amount, consume_date, sender, receiver, note) " +
            "values (#{mc.consumeId}, #{mc.workId}, #{mc.materialId}, #{mc.consumeAmount}, #{mc.consumeDate}, #{mc.sender}, #{mc.receiver}, #{mc.note})")
    int insertMaterialConsume(@Param("mc") MaterialConsume materialConsume);

    @Update("update material_consume set note = #{mc.note} where consume_id = #{mc.consumeId}")
    int updateNoteById(@Param("mc") MaterialConsume materialConsume);

    @Update("update material_consume set work_id = #{mc.workId}, material_id = #{mc.materialId}, consume_amount = #{mc.consumeAmount}, consume_date = #{mc.consumeDate}, sender = #{mc.sender}, receiver = #{mc.receiver}, note = #{mc.note} where consume_id = #{mc.consumeId}")
    int updateAllById(@Param("mc") MaterialConsume materialConsume);

    int deleteMaterialConsumesByIds(@Param("ids") String[] ids);*/
}