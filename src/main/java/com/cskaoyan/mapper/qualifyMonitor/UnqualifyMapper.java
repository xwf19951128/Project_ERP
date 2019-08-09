package com.cskaoyan.mapper.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.UnqualifyApply;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UnqualifyMapper {
    // 查询不合格产品申请表
    List<UnqualifyApply> queryUnqualifyApply();
}
