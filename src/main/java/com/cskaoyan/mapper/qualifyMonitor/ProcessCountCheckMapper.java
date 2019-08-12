package com.cskaoyan.mapper.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.ProcessCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessCountCheckMapper {
    // 查询全部数据
    List<ProcessCountCheck> queryProcessCountCheck();

    // 插入
    int insertProcessCountCheck(@Param("processCountCheck") ProcessCountCheck processCountCheck);

    // 删除
    int deleteProcessCountCheckById(@Param("ids") String[] ids);

    // 编辑
    int editProcessCountCheck(@Param("processCountCheck") ProcessCountCheck processCountCheck);

    // 根据id进行模糊查询
    List<ProcessCountCheck> searchPCountCheckById(@Param("id") String id);
}
