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

    @Override
    public List<MaterialConsume> listPageSearchMaterialConsumesByConsumeId(int page, int rows, String searchValue) {
//        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
//        materialConsumeExample.createCriteria().andConsumeIdLike("%" + searchValue + "%");
        String like = "%" + searchValue + "%";
        PageHelper.startPage(page, rows);
        return materialConsumeMapper.listAllSearchMaterialConsumesByConsumeId(like);
    }

    @Override
    public List<MaterialConsume> listPageSearchMaterialConsumesByWorkId(int page, int rows, String searchValue) {
        String like = "%" + searchValue + "%";
        PageHelper.startPage(page, rows);
        return materialConsumeMapper.listAllSearchMaterialConsumesByWorkId(like);
    }

    @Override
    public List<MaterialConsume> listPageSearchMaterialConsumesByMaterialId(int page, int rows, String searchValue) {
        String like = "%" + searchValue + "%";
        PageHelper.startPage(page, rows);
        return materialConsumeMapper.listAllSearchMaterialConsumesByMaterialId(like);
    }
}
