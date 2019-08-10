package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.EndProductQualify;
import com.cskaoyan.mapper.qualifyMonitor.EndProductQualifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndProductQualifyServiceImpl implements EndProductQualifyService {

    @Autowired
    EndProductQualifyMapper endProductQualifyMapper;

    @Override
    public List<EndProductQualify> EndProductQualify() {
        return endProductQualifyMapper.queryEndProductQualify();
    }

    @Override
    public int insertEndProductQualify(EndProductQualify endProductQualify) {
        return endProductQualifyMapper.insertEndProductQualify(endProductQualify);
    }
}
