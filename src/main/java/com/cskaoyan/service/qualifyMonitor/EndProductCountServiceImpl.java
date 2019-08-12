package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.EndProductCount;
import com.cskaoyan.mapper.qualifyMonitor.EndProductCountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndProductCountServiceImpl implements EndProductCountService {

    @Autowired
    EndProductCountMapper endProductCountMapper;

    // 查询全部数据
    @Override
    public List<EndProductCount> queryEndProductCount() {
        return endProductCountMapper.queryEndProductCount();
    }

    // 插入
    @Override
    public int insertEndProductCount(EndProductCount endProductCount) {
        return endProductCountMapper.insertEndProductCount(endProductCount);
    }

    // 删除
    @Override
    public int deleteEndProductCountById(String[] ids) {
        return endProductCountMapper.deleteEndProductCountById(ids);
    }

    // 编辑
    @Override
    public int editEndProductCount(EndProductCount endProductCount) {
        return endProductCountMapper.editEndProductCount(endProductCount);
    }

    // 根据id进行模糊查询
    @Override
    public List<EndProductCount> searchEndProductCountById(String id) {
        return endProductCountMapper.searchEndProductCountById(id);
    }

    // 根据订单编号进行模糊查询
    @Override
    public List<EndProductCount> searchEndProductCountByOrderId(String orderId) {
        return endProductCountMapper.searchEndProductCountByOrderId(orderId);
    }
}
