package com.example.test_physical_strength.mapper;

import com.example.test_physical_strength.model.SysTest;
import com.example.test_physical_strength.model.SysTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysTestMapper {
    int countByExample(SysTestExample example);

    int deleteByExample(SysTestExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysTest record);

    int insertSelective(SysTest record);

    List<SysTest> selectByExample(SysTestExample example);

    SysTest selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysTest record, @Param("example") SysTestExample example);

    int updateByExample(@Param("record") SysTest record, @Param("example") SysTestExample example);

    int updateByPrimaryKeySelective(SysTest record);

    int updateByPrimaryKey(SysTest record);
}