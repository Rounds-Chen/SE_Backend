package com.rounds.experimentalteachingsystm.mapper;

import com.rounds.experimentalteachingsystm.entity.ReportEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author czy
 * @since 2021-10-25
 */
@Mapper
public interface ReportMapper extends BaseMapper<ReportEntity> {

    @Select("SELECT * FROM report WHERE report_id=#{id}")
    List<ReportEntity> getOne(@Param("id") int id);

}
