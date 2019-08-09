package com.cskaoyan.mapper.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.MeasureCheck;

import java.util.List;

public interface MeasureCheckMapper {
    // 查询全部的工序计量质检
    List<MeasureCheck> queryMeasureCheck();
}
