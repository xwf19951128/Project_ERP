package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.UnqualifyApply;

import java.util.List;

public interface UnqualifyService {
    // 查询不合格产品申请表
    List<UnqualifyApply> queryUnqualifyApply();

    // 添加不合格产品
    int insertUnqualify(UnqualifyApply unqualifyApply);

    // 删除
    int deleteUnqualifyById(String[] ids);

    // 编辑
    int editUnqualify(UnqualifyApply unqualifyApply);

    // 根据id模糊查询
    List<UnqualifyApply> searchUnqualifyById(String id);

    // 根据名称模糊查询
    List<UnqualifyApply> searchUnqualifyByName(String name);
}
