package com.cskaoyan.service.technology;

import com.cskaoyan.bean.technology.TechnologyRequirement;

import java.util.List;

public interface TechnologyRequirementService {
    //查询所有的工艺要求
    public List<TechnologyRequirement> queryAllTechnologyRequirements();
}
