package com.cskaoyan.mapper.schedule;

import com.cskaoyan.bean.schedule.Custom;
import com.cskaoyan.bean.schedule.Work;
import com.cskaoyan.bean.schedule.WorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkMapper {
    List<Work> queryList(@Param("rows") Integer rows, @Param("page") int i);
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(String workId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    long queryCount();
}