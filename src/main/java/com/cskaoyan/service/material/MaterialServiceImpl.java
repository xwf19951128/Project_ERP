package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.Material;
import com.cskaoyan.mapper.material.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public List<Material> listMaterials() {
        return materialMapper.listMaterials();
    }

    @Override
    public List<Material> listPageMaterials(int page, int rows) {
//        PageHelper.startPage(page, rows);
        int limit = rows;
        int offset = (page-1)*rows;
        return materialMapper.listPageMaterials(limit, offset);
    }

    @Override
    public int countMaterialCount() {
        return materialMapper.countMaterialCount();
    }
}
