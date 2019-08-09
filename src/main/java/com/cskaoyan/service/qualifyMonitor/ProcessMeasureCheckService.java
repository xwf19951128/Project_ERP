package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.ProcessMeasureCheck;

import java.util.List;

public interface ProcessMeasureCheckService {
    // 查询全部的工序计量质检
    List<ProcessMeasureCheck> queryMeasureCheck();
}
