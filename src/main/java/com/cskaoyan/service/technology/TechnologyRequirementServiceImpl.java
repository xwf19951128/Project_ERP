package com.cskaoyan.service.technology;

import com.cskaoyan.bean.technology.TechnologyRequirement;
import com.cskaoyan.mapper.technology.TechnologyRequirementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {
    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

    @Override
    public List<TechnologyRequirement> queryAllTechnologyRequirements() {
        return technologyRequirementMapper.queryAllTechnologyRequirements();
    }
}
