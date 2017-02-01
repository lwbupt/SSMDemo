package com.ssmdemo.dao;

import com.ssmdemo.domain.Students;

public interface StudentsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);
}