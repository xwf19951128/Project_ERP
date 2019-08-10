package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.Material;
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
        return materialReceiveMapper.updateNoteById(materialReceive);
    }

    @Override
    public int updateAllById(MaterialReceive materialReceive, Material material) {
        return materialReceiveMapper.updateAllById(materialReceive, material);
    }

    @Override
    public int insertMaterialReceive(MaterialReceive materialReceive, Material material) {
        return materialReceiveMapper.insertMaterialReceive(materialReceive, material);
    }

    @Override
    public int deleteMaterialReceivesByIds(String[] ids) {
        return materialReceiveMapper.deleteMaterialReceivesByIds(ids);
    }

    @Override
    public int countSearchMaterialReceiveCountByReceiveId(String searchValue) {
        String like = "%" + searchValue + "%";
        return materialReceiveMapper.countSearchMaterialReceiveCountByReceiveId(like);
    }

    @Override
    public List<MaterialReceive> listPageSearchMaterialReceivesByReceiveId(int page, int rows, String searchValue) {
        int limit = rows;
        int offset = (page-1)*rows;
        String like = "%" + searchValue + "%";
        return materialReceiveMapper.listPageSearchMaterialReceivesByReceiveId(limit, offset, like);
    }

    @Override
    public int countSearchMaterialReceiveCountByMaterialId(String searchValue) {
        String like = "%" + searchValue + "%";
        return materialReceiveMapper.countSearchMaterialReceiveCountByMaterialId(like);
    }

    @Override
    public List<MaterialReceive> listPageSearchMaterialReceivesByMaterialId(int page, int rows, String searchValue) {
        int limit = rows;
        int offset = (page-1)*rows;
        String like = "%" + searchValue + "%";
        return materialReceiveMapper.listPageSearchMaterialReceivesByMaterialId(limit, offset, like);
    }
}
