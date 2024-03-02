package info.jiaying.back_end.mapper;

import info.jiaying.back_end.model.TaskMetaCfg;
import info.jiaying.back_end.model.TaskMetaCfgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskMetaCfgMapper {
    long countByExample(TaskMetaCfgExample example);

    int deleteByExample(TaskMetaCfgExample example);

    int deleteByPrimaryKey(String taskType);

    int insert(TaskMetaCfg record);

    int insertSelective(TaskMetaCfg record);

    List<TaskMetaCfg> selectByExample(TaskMetaCfgExample example);

    TaskMetaCfg selectByPrimaryKey(String taskType);

    int updateByExampleSelective(@Param("record") TaskMetaCfg record, @Param("example") TaskMetaCfgExample example);

    int updateByExample(@Param("record") TaskMetaCfg record, @Param("example") TaskMetaCfgExample example);

    int updateByPrimaryKeySelective(TaskMetaCfg record);

    int updateByPrimaryKey(TaskMetaCfg record);
}