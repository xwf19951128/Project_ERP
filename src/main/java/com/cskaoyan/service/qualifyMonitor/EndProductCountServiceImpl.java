package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.EndProductCount;
import com.cskaoyan.mapper.qualifyMonitor.EndProductCountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndProductCountServiceImpl implements EndProductCountService {

    @Autowired
    EndProductCountMapper endProductCountMapper;

    @Override
    public List<EndProductCount> queryEndProductCount() {
        return endProductCountMapper.queryEndProductCount();
    }
}
