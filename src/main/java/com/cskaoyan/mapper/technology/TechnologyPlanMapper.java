package com.cskaoyan.mapper.technology;

import com.cskaoyan.bean.technology.Technology;
import com.cskaoyan.bean.technology.TechnologyPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyPlanMapper {
    /**
     * 查询所有technologyPlan
     * */
    public List<TechnologyPlan> queryAllTechPlans();
    /**
     * 增加新的工艺计划
     * */
    public int insertTechnologyPlan(@Param("technologyPlan") TechnologyPlan technologyPlan);
    /**
     * 根据ids数组批量删除工艺计划
     * */
    public int deleteTechnologyPlan(@Param("ids")int[] ids);
    /**
     * 更新记录
     * */
    public int updateTechnologyPlan(@Param("techPlan")TechnologyPlan technologyPlan);
    /**
     * 根据id查询一条plan
     * */
    public TechnologyPlan queryTechPlanById(@Param("id")String id);
    /**
     *根据工艺计划编号模糊搜索
     * */
    public List<TechnologyPlan> queryPlanByPlanId(@Param("value") String searchValue);
    /**
     * 根据工艺名称模糊搜索
     * */
    public List<TechnologyPlan> queryPlanByTechName(@Param("value") String searchValue);
}
