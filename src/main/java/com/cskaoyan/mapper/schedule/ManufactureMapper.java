package com.cskaoyan.mapper.schedule;

import com.cskaoyan.bean.schedule.Custom;
import com.cskaoyan.bean.schedule.Manufacture;
import com.cskaoyan.bean.schedule.ManufactureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManufactureMapper {
    List<Manufacture> queryList(@Param("page") int page,@Param("rows") int rows);
    List<Manufacture> queryManufacture();
    long countByExample(ManufactureExample example);

    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int deleteByManufacture_sn(String[] manufactureSn);
    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    List<Manufacture> selectByExample(ManufactureExample example);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByExampleSelective(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByExample(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    long countNumber();

    List<Manufacture> searchManufactureByTecName(@Param("value") String s);

    List<Manufacture> searchManufactureByID(@Param("value")String s);

    List<Manufacture> searchManufactureByOrderID(@Param("value")String s);
}