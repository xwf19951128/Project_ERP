package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.ProcessMeasureCheck;
import com.cskaoyan.mapper.qualifyMonitor.ProcessMeasureCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessMeasureCheckServiceImpl implements ProcessMeasureCheckService {

    // 取出这个接口。
    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;

    // 查询全部的工序计量质检
    @Override
    public List<ProcessMeasureCheck> queryMeasureCheck() {
        return processMeasureCheckMapper.queryMeasureCheck();
    }

    // 插入
    @Override
    public int insertProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck) {
        return processMeasureCheckMapper.insertProcessMeasureCheck(processMeasureCheck);
    }

    // 删除
    @Override
    public int deleteProcessMeasureCheckById(String[] ids) {
        return processMeasureCheckMapper.deleteProcessMeasureCheckById(ids);
    }

    // 编辑
    @Override
    public int editProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck) {
        return processMeasureCheckMapper.editProcessMeasureCheck(processMeasureCheck);
    }

    // 根据id模糊查询
    @Override
    public List<ProcessMeasureCheck> searchPMeasureCheckById(String id) {
        return processMeasureCheckMapper.searchPMeasureCheckById(id);
    }
}
