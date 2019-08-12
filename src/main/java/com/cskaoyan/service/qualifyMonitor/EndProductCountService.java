package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.EndProductCount;

import java.util.List;

public interface EndProductCountService {
    // 查询全部数据
    List<EndProductCount> queryEndProductCount();

    // 插入
    int insertEndProductCount(EndProductCount endProductCount);

    // 删除
    int deleteEndProductCountById(String[] ids);

    // 编辑
    int editEndProductCount(EndProductCount endProductCount);

    // 根据id进行模糊查询
    List<EndProductCount> searchEndProductCountById(String id);

    // 根据订单编号进行模糊查询
    List<EndProductCount> searchEndProductCountByOrderId(String orderId);
}
