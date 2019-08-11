package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.EndProductQualify;
import com.cskaoyan.mapper.qualifyMonitor.EndProductQualifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndProductQualifyServiceImpl implements EndProductQualifyService {

    @Autowired
    EndProductQualifyMapper endProductQualifyMapper;

    // 查询全部数据
    @Override
    public List<EndProductQualify> EndProductQualify() {
        return endProductQualifyMapper.queryEndProductQualify();
    }

    // 新增
    @Override
    public int insertEndProductQualify(EndProductQualify endProductQualify) {
        return endProductQualifyMapper.insertEndProductQualify(endProductQualify);
    }

    // 删除
    @Override
    public int deleteEndProductQualifyById(String[] ids) {
        return endProductQualifyMapper.deleteEndProductQualifyById(ids);
    }

    // 编辑
    @Override
    public int editEndProductQualify(EndProductQualify endProductQualify) {
        return endProductQualifyMapper.editEndProductQualify(endProductQualify);
    }

    // 根据id进行模糊查询
    @Override
    public List<EndProductQualify> searchEndProductQualifyById(String id) {
        return endProductQualifyMapper.searchEndProductQualifyById(id);
    }

    // 根据订单号进行模糊查询
    @Override
    public List<EndProductQualify> searchEndProductQualifyByOrderId(String orderId) {
        return endProductQualifyMapper.searchEndProductQualifyByOrderId(orderId);
    }
}
