package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.ProcessCountCheck;
import com.cskaoyan.bean.qualifyMonitor.ProcessMeasureCheck;

import java.util.List;

public interface ProcessMeasureCheckService {
    // 查询全部的工序计量质检
    List<ProcessMeasureCheck> queryMeasureCheck();

    // 插入
    int insertProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck);

    // 删除
    int deleteProcessMeasureCheckById(String[] ids);

    // 编辑
    int editProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck);

    // 根据id进行模糊查询
    List<ProcessMeasureCheck> searchPMeasureCheckById(String id);

}
