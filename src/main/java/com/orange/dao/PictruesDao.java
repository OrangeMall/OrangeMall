package com.orange.dao;

import com.orange.vo.Pictrues;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PictruesDao {
    public List<Pictrues> selectpictrues(@Param("pid") int pid);
}
