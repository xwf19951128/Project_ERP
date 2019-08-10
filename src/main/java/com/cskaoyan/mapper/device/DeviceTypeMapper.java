package com.cskaoyan.mapper.device;

import com.cskaoyan.bean.device.DeviceType;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 10:49 2019/8/9
 */
public interface DeviceTypeMapper {
    //查询所有的结果
    List<DeviceType> queryAllDeviceType();

    //新增一个数据
    int insertDeviceType(DeviceType deviceType);

    //删除一个或多个数据
    int deleteDeviceType(String[] deviceTypes);

    //更新一个数据
    int updateDeviceType(DeviceType deviceType);

    //进行判断重复操作，
    DeviceType queryDeviceTypeById(String deviceTypeId);

    //模糊查询，根据输入的值，在sql语句中进行模糊搜索。
    List<DeviceType> queryDeviceTypeByDeviceTypeId(String searchValue);

    //模糊查询2，根据输入的值，在sql语句中进行模糊搜索
    List<DeviceType> searchDeviceTypeByDeviceTypeName(String searchValue);


}
