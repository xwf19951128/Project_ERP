package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.MaterialConsume;
import com.cskaoyan.bean.material.MaterialReceive;

import java.util.List;

public interface MaterialConsumeService {

    List<MaterialConsume> listPageMaterialConsumes(int page, int rows);
}
