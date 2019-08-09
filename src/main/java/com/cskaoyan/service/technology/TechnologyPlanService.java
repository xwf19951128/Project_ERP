package com.cskaoyan.service.technology;

import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.bean.technology.TechnologyRequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyPlanService {
    /**
     * 联立technology-plan和technology
     * */
    public List<TechnologyPlan> queryAllTechPlans();
    //新增一个工艺计划
    public int insertTechnologyPlan(TechnologyPlan technologyPlan);
    //根据ids批量删除
    public int deleteTechnologyPlan(int[] ids);
    //更新记录
    public int updateTechnologyPlan(TechnologyPlan technologyPlan);
}
