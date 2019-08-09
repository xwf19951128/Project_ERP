package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.Material;

import java.util.List;

public interface MaterialService {

    List<Material> listMaterials();

    List<Material> listPageMaterials(int page, int rows);

    int countMaterialCount();
}
