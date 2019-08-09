package com.cskaoyan.service.technology;

import com.cskaoyan.bean.technology.Technology;
import com.cskaoyan.bean.technology.TechnologyRequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyService {
    //查询所有的工艺
    public List<Technology> queryAllTechnologies();
    //新增一条工艺
    public int insertTechnology( Technology technology);
    //根据ids批量删除
    public int deleteTechnology(int[] ids);
    //更新记录
    public int updateTechnology(Technology technology);
}
