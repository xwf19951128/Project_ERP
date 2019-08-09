package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.MeasureCheck;
import com.cskaoyan.mapper.qualifyMonitor.MeasureCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MeasureCheckServiceImpl implements MeasureCheckService {

    // 取出这个接口。
    @Autowired
    MeasureCheckMapper measureCheckMapper;

    // 查询全部的工序计量质检
    @Override
    public List<MeasureCheck> queryMeasureCheck() {
        return measureCheckMapper.queryMeasureCheck();
    }
}
