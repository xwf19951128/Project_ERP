package com.cskaoyan.service.technology;

import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.bean.technology.TechnologyRequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessService {
    //查询所有的process表中记录
    public List<Process> queryAllProcesses();
    //新增process
    public int insertProcess(Process process);
    //根据ids批量删除
    public int deleteProcess(int[] ids);
    //更新记录
    public int updateProcess(Process process);
    /**
     * 根据工序id模糊搜索
     * */
    public List<Process> queryProcessByProcessId(String searchValue);
    /**
     * 根据工艺计划id模糊搜索
     * */
    public List<Process> queryProcessByPlanId(String searchValue);
}
