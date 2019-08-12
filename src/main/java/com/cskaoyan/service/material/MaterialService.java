package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.Material;

import java.util.List;

public interface MaterialService {

    List<Material> listMaterials();

    List<Material> listPageMaterials(int page, int rows);

    int countMaterialCount();

    int insertMaterial(Material material);

    int updateNoteById(Material material);

    int updateAllById(Material material);

    int deleteMaterialsByIds(String[] ids);

    int countSearchMaterialCountById(String searchValue);

    List<Material> listPageSearchMaterialsById(int page, int rows, String searchValue);

    int countSearchMaterialCountByType(String searchValue);

    List<Material> listPageSearchMaterialsByType(int page, int rows, String searchValue);

    Material getMaterialById(String materialId);
}
