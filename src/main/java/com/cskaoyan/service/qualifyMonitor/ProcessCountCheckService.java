package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.ProcessCountCheck;

import java.util.List;

public interface ProcessCountCheckService {
    // 查询全部数据
    List<ProcessCountCheck> queryProcessCountCheck();

    // 插入
    int insertProcessCountCheck(ProcessCountCheck processCountCheck);

    // 删除
    int deleteProcessCountCheckById(String[] ids);

    // 编辑
    int editProcessCountCheck(ProcessCountCheck processCountCheck);

    // 根据id进行模糊查询
    List<ProcessCountCheck> searchPCountCheckById(String id);
}
