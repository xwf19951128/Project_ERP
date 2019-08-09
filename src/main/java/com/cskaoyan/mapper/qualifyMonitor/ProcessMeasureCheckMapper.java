package com.cskaoyan.mapper.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.ProcessMeasureCheck;

import java.util.List;

public interface ProcessMeasureCheckMapper {
    // 查询全部的工序计量质检
    List<ProcessMeasureCheck> queryMeasureCheck();
}
