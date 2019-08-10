package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.MaterialConsume;
import com.cskaoyan.bean.material.MaterialConsumeExample;
import com.cskaoyan.bean.material.MaterialReceive;
import com.cskaoyan.mapper.material.MaterialConsumeMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Override
    public List<MaterialConsume> listPageMaterialConsumes(int page, int rows) {
/*        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        PageHelper.startPage(page, rows);
        materialConsumeExample.createCriteria().andConsumeIdIsNotNull();
        return materialConsumeMapper.selectByExample(materialConsumeExample);*/
        PageHelper.startPage(page, rows);
        return materialConsumeMapper.listAllMaterialConsumes();
    }
}
