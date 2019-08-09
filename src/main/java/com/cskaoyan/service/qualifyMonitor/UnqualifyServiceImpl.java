package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.UnqualifyApply;
import com.cskaoyan.mapper.qualifyMonitor.UnqualifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnqualifyServiceImpl implements UnqualifyService {

    @Autowired
    UnqualifyMapper unqualifyMapper;

    @Override
    public List<UnqualifyApply> queryUnqualifyApply() {
        return unqualifyMapper.queryUnqualifyApply();
    }
}
