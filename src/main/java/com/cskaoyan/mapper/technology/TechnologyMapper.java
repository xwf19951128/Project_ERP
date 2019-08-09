package com.cskaoyan.mapper.technology;

import com.cskaoyan.bean.technology.Technology;

import java.util.List;

public interface TechnologyMapper {
    /**
     * 查询所有的工艺
     * */
    public List<Technology> queryAllTechnologies();
}
