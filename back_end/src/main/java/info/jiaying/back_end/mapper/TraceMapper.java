package info.jiaying.back_end.mapper;

import info.jiaying.back_end.model.Trace;
import info.jiaying.back_end.model.TraceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TraceMapper {
    long countByExample(TraceExample example);

    int deleteByExample(TraceExample example);

    int deleteByPrimaryKey(Integer traceId);

    int insert(Trace record);

    int insertSelective(Trace record);

    List<Trace> selectByExample(TraceExample example);

    Trace selectByPrimaryKey(Integer traceId);

    int updateByExampleSelective(@Param("record") Trace record, @Param("example") TraceExample example);

    int updateByExample(@Param("record") Trace record, @Param("example") TraceExample example);

    int updateByPrimaryKeySelective(Trace record);

    int updateByPrimaryKey(Trace record);
}