package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.MaterialReceive;
import com.cskaoyan.mapper.material.MaterialReceiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;


    @Override
    public int countMaterialReceiveCount() {
        return materialReceiveMapper.countMaterialReceiveCount();
    }

    @Override
    public List<MaterialReceive> listPageMaterialReceives(int page, int rows) {
        int limit = rows;
        int offset = (page-1)*rows;
        return materialReceiveMapper.listPageMaterialReceives(limit, offset);
    }

    @Override
    public int updateNoteById(MaterialReceive materialReceive) {
        return 0;
    }

    @Override
    public int updateAllById(MaterialReceive materialReceive) {
        return 0;
    }

    @Override
    public int insertMaterialReceive(MaterialReceive material) {
        return 0;
    }

    @Override
    public int deleteMaterialReceivesByIds(String[] ids) {
        return 0;
    }

    @Override
    public int countSearchMaterialReceiveCountById(String searchValue) {
        return 0;
    }

    @Override
    public List<MaterialReceive> listPageSearchMaterialReceivesById(int page, int rows, String searchValue) {
        return null;
    }

    @Override
    public int countSearchMaterialCountByType(String searchValue) {
        return 0;
    }

    @Override
    public List<MaterialReceive> listPageSearchMaterialsByType(int page, int rows, String searchValue) {
        return null;
    }
}
