package com.cskaoyan.service.technology;

import com.cskaoyan.bean.technology.Process;

import java.util.List;

public interface ProcessService {
    //查询所有的process表中记录
    public List<Process> queryAllProcesses();
}
