package com.ssmdemo.dao;

import com.ssmdemo.domain.Cources;

public interface CourcesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Cources record);

    int insertSelective(Cources record);

    Cources selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cources record);

    int updateByPrimaryKey(Cources record);
}