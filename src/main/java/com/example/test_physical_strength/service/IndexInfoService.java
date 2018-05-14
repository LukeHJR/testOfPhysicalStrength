package com.example.test_physical_strength.service;

import com.example.test_physical_strength.model.SysInfo;

import java.util.List;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-12
 */
public interface IndexInfoService {

    /**
     * @param
     * @return
     * @title 公告信息
     * @author huangjiarui
     * @date 2018年5月12日
     */
    List<SysInfo> indexInfo();

    /**
     * @param
     * @return
     * @title 添加公告信息
     * @author huangjiarui
     * @date 2018年5月12日
     */
    void indexAddInfo(String title , String content);

}
