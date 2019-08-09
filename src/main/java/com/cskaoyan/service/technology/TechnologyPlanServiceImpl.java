package com.cskaoyan.service.technology;

import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.mapper.technology.TechnologyPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TechnologyPlanServiceImpl implements TechnologyPlanService {

    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Override
    //查询所有的工艺计划
    public List<TechnologyPlan> queryAllTechPlans() {
        return technologyPlanMapper.queryAllTechPlans();
    }
}
