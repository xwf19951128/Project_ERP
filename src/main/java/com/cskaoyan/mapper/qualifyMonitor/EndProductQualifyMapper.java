package com.cskaoyan.mapper.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.EndProductQualify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


public interface EndProductQualifyMapper {
    // 查询成品计量质检
    List<EndProductQualify> queryEndProductQualify();

    // 新增成品计量质检
    int insertEndProductQualify(@Param("endProductQualify") EndProductQualify endProductQualify);
}
