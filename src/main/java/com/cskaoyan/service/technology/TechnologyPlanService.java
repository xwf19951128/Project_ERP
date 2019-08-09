package com.cskaoyan.service.technology;

import com.cskaoyan.bean.technology.TechnologyPlan;

import java.util.List;

public interface TechnologyPlanService {
    /**
     * 联立technology-plan和technology
     * */
    public List<TechnologyPlan> queryAllTechPlans();
}
