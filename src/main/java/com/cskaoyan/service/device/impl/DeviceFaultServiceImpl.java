package com.cskaoyan.service.device.impl;

import com.cskaoyan.bean.device.DeviceFault;
import com.cskaoyan.mapper.device.DeviceFaultMapper;
import com.cskaoyan.service.device.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 15:30 2019/8/9
 */
@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper mapper;

    @Override
    public List<DeviceFault> queryAllDeviceFault() {
        return mapper.queryAllDeviceFault();
    }

    @Override
    public int insertDeviceFault(DeviceFault deviceFault) {
        //首先要进行重复id判断操作，如果数据库中有相同id，则返回true
        DeviceFault deviceFault1 = mapper.queryDeviceFaultById(deviceFault.getDeviceFaultId());
        if(deviceFault1!=null){
            return 2;
        }else{
            return mapper.insertDeviceFault(deviceFault);
        }

    }

    @Override
    public List<DeviceFault> searchDeviceFaultByDeviceFaultId(String searchValue) {
        return mapper.searchDeviceFaultByDeviceFaultId(searchValue);
    }

    @Override
    public List<DeviceFault> searchDeviceFaultByDeviceFaultName(String searchValue) {
        return mapper.searchDeviceFaultByDeviceFaultName(searchValue);
    }

    @Override
    public int updateDeviceFault(DeviceFault deviceFault) {
        return mapper.updateDeviceFault(deviceFault);
    }

    @Override
    public int deleteDeviceFault(String[] deviceFault) {
        return mapper.deleteDeviceFault(deviceFault);
    }
}
