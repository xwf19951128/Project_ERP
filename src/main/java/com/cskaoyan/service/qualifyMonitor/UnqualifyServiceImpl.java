package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.UnqualifyApply;
import com.cskaoyan.mapper.qualifyMonitor.UnqualifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    // 删除
    @Override
    public int deleteUnqualifyById(String[] ids) {
        return unqualifyMapper.deleteUnqualifyById(ids);
    }

    // 编辑
    @Override
    public int editUnqualify(UnqualifyApply unqualifyApply) {
        return unqualifyMapper.editUnqualify(unqualifyApply);
    }

    // 根据id进行模糊查询
    @Override
    public List<UnqualifyApply> searchUnqualifyById(String id) {
        return unqualifyMapper.searchUnqualifyById(id);
    }

    // 根据产品名称进行模糊查询
    @Override
    public List<UnqualifyApply> searchUnqualifyByName(String name) {
        return unqualifyMapper.searchUnqualifyByName(name);
    }

}
