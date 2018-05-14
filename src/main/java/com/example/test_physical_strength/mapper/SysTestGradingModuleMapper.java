package com.example.test_physical_strength.mapper;

import com.example.test_physical_strength.model.SysTestGradingModule;
import com.example.test_physical_strength.model.SysTestGradingModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysTestGradingModuleMapper {
    int countByExample(SysTestGradingModuleExample example);

    int deleteByExample(SysTestGradingModuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysTestGradingModule record);

    int insertSelective(SysTestGradingModule record);

    List<SysTestGradingModule> selectByExample(SysTestGradingModuleExample example);

    SysTestGradingModule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysTestGradingModule record, @Param("example") SysTestGradingModuleExample example);

    int updateByExample(@Param("record") SysTestGradingModule record, @Param("example") SysTestGradingModuleExample example);

    int updateByPrimaryKeySelective(SysTestGradingModule record);

    int updateByPrimaryKey(SysTestGradingModule record);
}