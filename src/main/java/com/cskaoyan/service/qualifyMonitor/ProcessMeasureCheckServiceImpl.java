package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.ProcessMeasureCheck;
import com.cskaoyan.mapper.qualifyMonitor.ProcessMeasureCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService {

    // 取出这个接口。
    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;

    // 查询全部的工序计量质检
    @Override
    public List<ProcessMeasureCheck> queryMeasureCheck() {
        return processMeasureCheckMapper.queryMeasureCheck();
    }
}
