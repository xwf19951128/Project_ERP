package com.cskaoyan.service.technology;

import com.cskaoyan.bean.technology.TechnologyRequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementService {
    //查询所有的工艺要求
    public List<TechnologyRequirement> queryAllTechnologyRequirements();
    //新增一条工艺要求
    public int insertTechnologyRequirement(TechnologyRequirement technologyRequirement);
    //根据ids批量删除
    public int deleteTechnologyRequirement(int[] ids);
    //更新记录
    public int updateTechnologyRequirement(TechnologyRequirement technologyRequirement);
    //更新工艺要求
    public int updateNote(String technologyRequirementId, String requirement);
    /**
     * 根据工艺要求编号模糊查询
     * */
    public List<TechnologyRequirement> queryRequireByRequireId(String searchValue);
    /**
     * 根据工艺名称模糊查询
     * */
    public List<TechnologyRequirement> queryRequireByTechName(String searchValue);
}
