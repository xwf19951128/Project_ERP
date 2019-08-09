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

    @Override
    public int insertTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        return technologyRequirementMapper.insertTechnologyRequirement(technologyRequirement);
    }

    @Override
    public int deleteTechnologyRequirement(int[] ids) {
        return technologyRequirementMapper.deleteTechnologyRequirement(ids);
    }

    @Override
    public int updateTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        return technologyRequirementMapper.updateTechnologyRequirement(technologyRequirement);
    }

    @Override
    public int updateNote(String technologyRequirementId, String requirement) {
        return technologyRequirementMapper.updateNote(technologyRequirementId,requirement);
    }

    @Override
    public List<TechnologyRequirement> queryRequireByRequireId(String searchValue) {
        return technologyRequirementMapper.queryRequireByRequireId(searchValue);
    }

    @Override
    public List<TechnologyRequirement> queryRequireByTechName(String searchValue) {
        return technologyRequirementMapper.queryRequireByTechName(searchValue);
    }
}
