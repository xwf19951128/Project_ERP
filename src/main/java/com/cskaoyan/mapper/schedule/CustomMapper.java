package com.cskaoyan.mapper.schedule;

import com.cskaoyan.bean.schedule.Custom;
import com.cskaoyan.bean.schedule.CustomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomMapper {
    long countByExample(CustomExample example);

    int deleteByExample(CustomExample example);

    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    List<Custom> selectByExample(CustomExample example);
    List<Custom> queryList();

    Custom selectByPrimaryKey(String customId);

    int updateByExampleSelective(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByExample(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    List<Custom> searchCustomListByID(@Param("id") String s);

    List<Custom> searchCustomListByName(@Param("id") String s);
}