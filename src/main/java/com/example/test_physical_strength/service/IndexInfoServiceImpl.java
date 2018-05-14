package com.example.test_physical_strength.service;

import com.example.test_physical_strength.mapper.SysInfoMapper;
import com.example.test_physical_strength.model.SysInfo;
import com.example.test_physical_strength.model.SysInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-14
 */
@Service
public class IndexInfoServiceImpl implements IndexInfoService {

    @Autowired
    private SysInfoMapper sysInfoMapper;

    @Override
    public List<SysInfo> indexInfo() {
        SysInfoExample example = new SysInfoExample();
        SysInfoExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("create_time desc");
        return sysInfoMapper.selectByExample(example);
    }

    @Override
    public void indexAddInfo(String title , String content) {
        SysInfo sysInfo = new SysInfo();
        sysInfo.setContent(content);
        sysInfo.setTitle(title);
        sysInfoMapper.insertSelective(sysInfo);
    }
}
