package com.cskaoyan.service;

import com.cskaoyan.bean.Material;

import java.util.List;

public interface MaterialService {

    List<Material> listMaterials();

    List<Material> listPageMaterials(int page, int rows);
}
