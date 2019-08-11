package com.cskaoyan.mapper.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.EndProductCount;
import com.cskaoyan.bean.qualifyMonitor.EndProductQualify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EndProductCountMapper {
    // 查询全部数据
    List<EndProductCount> queryEndProductCount();

    // 插入
    int insertEndProductCount(@Param("endProductCount") EndProductCount endProductCount);

    // 删除
    int deleteEndProductCountById(@Param("ids") String[] ids);

    // 编辑
    int editEndProductCount(@Param("endProductCount") EndProductCount endProductCount);

    // 根据id进行模糊查询
    List<EndProductCount> searchEndProductCountById(@Param("id") String id);

    // 根据订单编号进行模糊查询
    List<EndProductCount> searchEndProductCountByOrderId(@Param("orderId") String orderId);
}
