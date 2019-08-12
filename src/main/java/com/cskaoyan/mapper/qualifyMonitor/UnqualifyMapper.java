package com.cskaoyan.mapper.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.UnqualifyApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnqualifyMapper {
    // 查询不合格产品申请表
    List<UnqualifyApply> queryUnqualifyApply();

    // 添加不合格产品
    int insertUnqualify(@Param("unqualifyApply") UnqualifyApply unqualifyApply);

    // 删除
    int deleteUnqualifyById(@Param("ids") String[] ids);

    // 编辑
    int editUnqualify(@Param("unqualifyApply") UnqualifyApply unqualifyApply);

    // 根据id模糊查询
    List<UnqualifyApply> searchUnqualifyById(@Param("id") String id);

    // 根据产品名称模糊查询
    List<UnqualifyApply> searchUnqualifyByName(@Param("productName") String name);
}
