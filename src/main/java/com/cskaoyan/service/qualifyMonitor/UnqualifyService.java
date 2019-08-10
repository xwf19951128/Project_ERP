package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.UnqualifyApply;

import java.util.List;

public interface UnqualifyService {
    // 查询不合格产品申请表
    List<UnqualifyApply> queryUnqualifyApply();

    // 添加不合格产品
    int insertUnqualify(UnqualifyApply unqualifyApply);
}
