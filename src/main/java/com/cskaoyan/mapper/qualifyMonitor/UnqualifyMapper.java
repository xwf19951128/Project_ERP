package com.cskaoyan.mapper.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.Product;
import com.cskaoyan.bean.qualifyMonitor.UnqualifyApply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UnqualifyMapper {
    // 查询不合格产品申请表
    List<UnqualifyApply> queryUnqualifyApply();

    // 添加不合格产品
    int insertUnqualify(@Param("unqualifyApply") UnqualifyApply unqualifyApply);

}
