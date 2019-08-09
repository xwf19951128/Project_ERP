package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.Product;
import com.cskaoyan.bean.qualifyMonitor.UnqualifyApply;
import com.cskaoyan.mapper.qualifyMonitor.UnqualifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnqualifyServiceImpl implements UnqualifyService {

    // 从容器中取出这个接口
    @Autowired
    UnqualifyMapper unqualifyMapper;

    // 查询不合格产品申请表
    @Override
    public List<UnqualifyApply> queryUnqualifyApply() {
        return unqualifyMapper.queryUnqualifyApply();
    }

    // 添加不合格产品
    @Override
    public int insertUnqualify(UnqualifyApply unqualifyApply) {
        return unqualifyMapper.insertUnqualify(unqualifyApply);
    }

}
