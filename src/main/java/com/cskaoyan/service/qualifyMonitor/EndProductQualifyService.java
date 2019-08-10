package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.EndProductQualify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EndProductQualifyService {
    // 查询成品计量质检
    List<EndProductQualify> EndProductQualify();

    // 新增成品计量质检
    int insertEndProductQualify(@Param("endProductQualify") EndProductQualify endProductQualify);
}
