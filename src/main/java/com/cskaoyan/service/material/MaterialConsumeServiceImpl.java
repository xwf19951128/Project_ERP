package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.MaterialConsume;
import com.cskaoyan.bean.material.MaterialConsumeExample;
import com.cskaoyan.bean.material.MaterialReceive;
import com.cskaoyan.mapper.material.MaterialConsumeMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Override
    public List<MaterialConsume> listPageMaterialConsumes(int page, int rows) {
        // 逆向工程不能以需要的格式封装
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

    @Override
    public int insertMaterialConsume(MaterialConsume materialConsume) {
//        return materialConsumeMapper.insertMaterialConsume(materialConsume);
        return materialConsumeMapper.insert(materialConsume);
    }

    @Override
    public int updateNoteById(MaterialConsume materialConsume) {
//        return materialConsumeMapper.updateNoteById(materialConsume);
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        materialConsumeExample.createCriteria().andConsumeIdLike(materialConsume.getConsumeId());
        return materialConsumeMapper.updateByExample(materialConsume, materialConsumeExample);
    }


    @Override
    public int updateAllById(MaterialConsume materialConsume) {
//        return materialConsumeMapper.updateAllById(materialConsume);
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        materialConsumeExample.createCriteria().andConsumeIdLike(materialConsume.getConsumeId());
        return materialConsumeMapper.updateByExample(materialConsume, materialConsumeExample);
    }

    @Override
    public int deleteMaterialConsumesByIds(String[] ids) {
//        return materialConsumeMapper.deleteMaterialConsumesByIds(ids);
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        ArrayList<String> idList = new ArrayList<>();
        Collections.addAll(idList, ids);
        materialConsumeExample.createCriteria().andConsumeIdIn(idList);
        return materialConsumeMapper.deleteByExample(materialConsumeExample);
    }
}
