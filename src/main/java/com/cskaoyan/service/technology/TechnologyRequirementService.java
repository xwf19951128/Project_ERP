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
}
