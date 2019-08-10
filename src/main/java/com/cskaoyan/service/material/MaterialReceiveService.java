package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.MaterialReceive;

import java.util.List;

public interface MaterialReceiveService {


    int countMaterialReceiveCount();

    List<MaterialReceive> listPageMaterialReceives(int page, int rows);

    int updateNoteById(MaterialReceive materialReceive);

    int updateAllById(MaterialReceive materialReceive);

    int insertMaterialReceive(MaterialReceive material);

    int deleteMaterialReceivesByIds(String[] ids);

    int countSearchMaterialReceiveCountById(String searchValue);

    List<MaterialReceive> listPageSearchMaterialReceivesById(int page, int rows, String searchValue);

    int countSearchMaterialCountByType(String searchValue);

    List<MaterialReceive> listPageSearchMaterialsByType(int page, int rows, String searchValue);
}
