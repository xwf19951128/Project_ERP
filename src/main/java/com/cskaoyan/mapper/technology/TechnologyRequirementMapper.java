package com.cskaoyan.mapper.technology;

import com.cskaoyan.bean.technology.Technology;
import com.cskaoyan.bean.technology.TechnologyRequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementMapper {
    /**
     * 查询所有的工艺要求
     * */
    public List<TechnologyRequirement> queryAllTechnologyRequirements();
    /**
     * 增加新的工艺需求
     * */
    public int insertTechnologyRequirement(@Param("technologyRequirement") TechnologyRequirement technologyRequirement);
    /**
     * 根据ids数组批量删除工艺需求
     * */
    public int deleteTechnologyRequirement(@Param("ids")int[] ids);
    /**
     * 更新记录
     * */
    public int updateTechnologyRequirement(@Param("techRequire") TechnologyRequirement technologyRequirement);
}
