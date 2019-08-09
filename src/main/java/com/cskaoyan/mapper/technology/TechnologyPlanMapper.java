package com.cskaoyan.mapper.technology;

import com.cskaoyan.bean.technology.TechnologyPlan;

import java.util.List;

public interface TechnologyPlanMapper {
    /**
     * 查询所有technologyPlan
     * */
    public List<TechnologyPlan> queryAllTechPlans();
}
