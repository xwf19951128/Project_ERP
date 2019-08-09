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

    @Override
    public int insertTechnologyPlan(TechnologyPlan technologyPlan) {
        return technologyPlanMapper.insertTechnologyPlan(technologyPlan);
    }

    @Override
    public int deleteTechnologyPlan(int[] ids) {
        return technologyPlanMapper.deleteTechnologyPlan(ids);
    }

    @Override
    public int updateTechnologyPlan(TechnologyPlan technologyPlan) {
        return technologyPlanMapper.updateTechnologyPlan(technologyPlan);
    }

    @Override
    public TechnologyPlan queryTechPlanById(String id) {
        return technologyPlanMapper.queryTechPlanById(id);
    }

    @Override
    public List<TechnologyPlan> queryPlanByPlanId(String searchValue) {
        return technologyPlanMapper.queryPlanByPlanId(searchValue);
    }

    @Override
    public List<TechnologyPlan> queryPlanByTechName(String searchValue) {
        return technologyPlanMapper.queryPlanByTechName(searchValue);
    }
}
