package com.cskaoyan.service.technology;

import com.cskaoyan.bean.technology.Technology;
import com.cskaoyan.mapper.technology.TechnologyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public List<Technology> queryAllTechnologies() {
        return technologyMapper.queryAllTechnologies();
    }

    @Override
    public int insertTechnology(Technology technology) {
        return technologyMapper.insertTechnology(technology);
    }

    @Override
    public int deleteTechnology(int[] ids) {
        return technologyMapper.deleteTechnology(ids);
    }

    @Override
    public int updateTechnology(Technology technology) {
        return technologyMapper.updateTechnology(technology);
    }

    @Override
    public Technology queryTechById(String id) {
        return technologyMapper.queryTechById(id);
    }

    @Override
    public List<Technology> queryTechByTechId(String searchValue) {
        return technologyMapper.queryTechByTechId(searchValue);
    }

    @Override
    public List<Technology> queryTechByTechName(String searchValue) {
        return technologyMapper.queryTechByTechName(searchValue);
    }
}
