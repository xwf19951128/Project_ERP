package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.EndProductQualify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EndProductQualifyService {
    // 查询成品计量质检
    List<EndProductQualify> EndProductQualify();

    // 新增成品计量质检
    int insertEndProductQualify(@Param("endProductQualify") EndProductQualify endProductQualify);

    // 删除成品计量质检
    int deleteEndProductQualifyById(String[] ids);

    // 编辑
    int editEndProductQualify(EndProductQualify endProductQualify);

    // 根据id进行模糊查询
    List<EndProductQualify> searchEndProductQualifyById(String id);

    // 根据订单号进行模糊查询
    List<EndProductQualify> searchEndProductQualifyByOrderId(String orderId);
}
