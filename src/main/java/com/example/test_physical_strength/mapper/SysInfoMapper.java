package com.example.test_physical_strength.mapper;

import com.example.test_physical_strength.model.SysInfo;
import com.example.test_physical_strength.model.SysInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysInfoMapper {
    int countByExample(SysInfoExample example);

    int deleteByExample(SysInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysInfo record);

    int insertSelective(SysInfo record);

    List<SysInfo> selectByExample(SysInfoExample example);

    SysInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysInfo record, @Param("example") SysInfoExample example);

    int updateByExample(@Param("record") SysInfo record, @Param("example") SysInfoExample example);

    int updateByPrimaryKeySelective(SysInfo record);

    int updateByPrimaryKey(SysInfo record);
}