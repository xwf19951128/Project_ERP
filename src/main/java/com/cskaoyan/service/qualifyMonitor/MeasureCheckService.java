package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.MeasureCheck;

import java.util.List;

public interface MeasureCheckService {
    // 查询全部的工序计量质检
    List<MeasureCheck> queryMeasureCheck();
}
