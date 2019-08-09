package com.cskaoyan.mapper.technology;

import com.cskaoyan.bean.technology.Process;

import java.util.List;

public interface ProcessMapper {
    /**
     * 这个方法是用来查询所有的Process表中工序记录，并且展示出来
     * */
    public List<Process> queryAllProcesses();
}
