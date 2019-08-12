package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.ProcessCountCheck;
import com.cskaoyan.mapper.qualifyMonitor.ProcessCountCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {

    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;

    // 查询全部
    @Override
    public List<ProcessCountCheck> queryProcessCountCheck() {
        return processCountCheckMapper.queryProcessCountCheck();
    }

    // 新增
    @Override
    public int insertProcessCountCheck(ProcessCountCheck processCountCheck) {
        return processCountCheckMapper.insertProcessCountCheck(processCountCheck);
    }

    // 删除
    @Override
    public int deleteProcessCountCheckById(String[] ids) {
        return processCountCheckMapper.deleteProcessCountCheckById(ids);
    }

    @Override
    public int editProcessCountCheck(ProcessCountCheck processCountCheck) {
        return processCountCheckMapper.editProcessCountCheck(processCountCheck);
    }

    // 根据id进行模糊查询
    @Override
    public List<ProcessCountCheck> searchPCountCheckById(String id) {
        return processCountCheckMapper.searchPCountCheckById(id);
    }
}
