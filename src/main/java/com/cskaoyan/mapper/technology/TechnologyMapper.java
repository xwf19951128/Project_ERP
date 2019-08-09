package com.cskaoyan.mapper.technology;

import com.cskaoyan.bean.technology.Technology;
import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.bean.technology.TechnologyRequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyMapper {
    /**
     * 查询所有的工艺
     * */
    public List<Technology> queryAllTechnologies();
    /**
     * 新增工艺
     * */
    public int insertTechnology(@Param("technology") Technology technology);
    /**
     * 根据ids数组批量删除工艺
     * */
    public int deleteTechnology(@Param("ids")int[] ids);
    /**
     * 更新记录
     * */
    public int updateTechnology(@Param("tech")Technology technology);

}
