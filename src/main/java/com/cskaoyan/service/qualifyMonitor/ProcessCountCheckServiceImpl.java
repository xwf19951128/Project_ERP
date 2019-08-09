package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.ProcessCountCheck;
import com.cskaoyan.mapper.qualifyMonitor.ProcessCountCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {

    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;

    @Override
    public List<ProcessCountCheck> queryProcessCountCheck() {
        return processCountCheckMapper.queryProcessCountCheck();
    }
}
