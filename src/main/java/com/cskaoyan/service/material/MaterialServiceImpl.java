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

    @Override
    public int insertMaterial(Material material) {
        return materialMapper.insertMaterial(material);
    }

    @Override
    public int updateNoteById(Material material) {
        return materialMapper.updateNoteById(material);
    }

    @Override
    public int updateAllById(Material material) {
        return materialMapper.updateAllById(material);
    }

    @Override
    public int deleteMaterialsByIds(String[] ids) {
        return materialMapper.deleteMaterialsByIds(ids);
    }

    @Override
    public int countSearchMaterialCountById(String searchValue) {
        String like = "%" + searchValue + "%";
        return materialMapper.countSearchMaterialCountById(like);
    }

    @Override
    public List<Material> listPageSearchMaterialsById(int page, int rows, String searchValue) {
        int limit = rows;
        int offset = (page-1)*rows;
        String like = "%" + searchValue + "%";
        return materialMapper.listPageSearchMaterialsById(limit, offset, like);
    }

    @Override
    public int countSearchMaterialCountByType(String searchValue) {
        String like = "%" + searchValue + "%";
        return materialMapper.countSearchMaterialCountByType(like);
    }

    @Override
    public List<Material> listPageSearchMaterialsByType(int page, int rows, String searchValue) {
        int limit = rows;
        int offset = (page-1)*rows;
        String like = "%" + searchValue + "%";
        return materialMapper.listPageSearchMaterialsByType(limit, offset, like);
    }

    @Override
    public Material getMaterialById(String materialId) {
        return materialMapper.getMaterialById(materialId);
    }
}
