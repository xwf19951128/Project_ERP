package com.cskaoyan.service;

import com.cskaoyan.bean.Material;
import com.cskaoyan.mapper.MaterialMapper;
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
        return null;
    }
}
