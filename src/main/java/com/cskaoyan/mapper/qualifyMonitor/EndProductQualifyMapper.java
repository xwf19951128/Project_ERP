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

    // 删除成品计量质检
    int deleteEndProductQualifyById(@Param("ids") String[] ids);

    // 编辑
    int editEndProductQualify(@Param("endProductQualify") EndProductQualify endProductQualify);

    // 根据id进行模糊查询
    List<EndProductQualify> searchEndProductQualifyById(@Param("id") String id);

    // 根据订单号进行模糊查询
    List<EndProductQualify> searchEndProductQualifyByOrderId(@Param("orderId") String orderId);
}
