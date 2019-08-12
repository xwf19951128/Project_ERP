package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.MaterialConsume;
import com.cskaoyan.bean.material.MaterialReceive;

import java.util.List;

public interface MaterialConsumeService {

    List<MaterialConsume> listPageMaterialConsumes(int page, int rows);

    List<MaterialConsume> listPageSearchMaterialConsumesByConsumeId(int page, int rows, String searchValue);

    List<MaterialConsume> listPageSearchMaterialConsumesByWorkId(int page, int rows, String searchValue);

    List<MaterialConsume> listPageSearchMaterialConsumesByMaterialId(int page, int rows, String searchValue);

    int insertMaterialConsume(MaterialConsume materialConsume);

    int updateNoteById(MaterialConsume materialConsume);

    int updateAllById(MaterialConsume materialConsume);

    int deleteMaterialConsumesByIds(String[] ids);
}
