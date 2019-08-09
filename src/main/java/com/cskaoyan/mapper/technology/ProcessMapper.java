package com.cskaoyan.mapper.technology;

import com.cskaoyan.bean.technology.Process;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMapper {
    /**
     * 这个方法是用来查询所有的Process表中工序记录，并且展示出来
     * */
    public List<Process> queryAllProcesses();

    /**
     * 这个方法是用来新增一条前端传过来的process记录
     * */
    public int insertProcess(@Param("process") Process process);

    /**
     * 根据ids数组批量删除工艺流程
     * */
    public int deleteProcess(@Param("ids")int[] ids);

    /**
     * 更新记录
     * */
    public int updateProcess(@Param("process")Process process);
    /**
     * 根据工序id模糊搜索
     * */
    public List<Process> queryProcessByProcessId(@Param("value") String searchValue);
    /**
     * 根据工艺计划id模糊搜索
     * */
    public List<Process> queryProcessByPlanId(@Param("value") String searchValue);
}
