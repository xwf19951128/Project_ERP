package com.cskaoyan.mapper.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.ProcessCountCheck;
import com.cskaoyan.bean.qualifyMonitor.ProcessMeasureCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMeasureCheckMapper {
    // 查询全部的工序计量质检
    List<ProcessMeasureCheck> queryMeasureCheck();

    // 插入
    int insertProcessMeasureCheck(@Param("processMeasureCheck") ProcessMeasureCheck processMeasureCheck);

    // 删除
    int deleteProcessMeasureCheckById(@Param("ids") String[] ids);

    // 编辑
    int editProcessMeasureCheck(@Param("processMeasureCheck") ProcessMeasureCheck processMeasureCheck);

    // 根据id进行模糊查询
    List<ProcessMeasureCheck> searchPMeasureCheckById(@Param("id") String id);
}
