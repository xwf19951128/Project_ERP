package com.cskaoyan.service.technology;

import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.mapper.technology.ProcessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;
    /**
     * 查询所有的process记录
     * */
    @Override
    public List<Process> queryAllProcesses() {
        return processMapper.queryAllProcesses();
    }
}
