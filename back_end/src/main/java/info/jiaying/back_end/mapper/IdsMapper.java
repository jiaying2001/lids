package info.jiaying.back_end.mapper;

import info.jiaying.back_end.model.Ids;
import info.jiaying.back_end.model.IdsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IdsMapper {
    long countByExample(IdsExample example);

    int deleteByExample(IdsExample example);

    int deleteByPrimaryKey(Integer idsId);

    int insert(Ids record);

    int insertSelective(Ids record);

    List<Ids> selectByExample(IdsExample example);

    Ids selectByPrimaryKey(Integer idsId);

    int updateByExampleSelective(@Param("record") Ids record, @Param("example") IdsExample example);

    int updateByExample(@Param("record") Ids record, @Param("example") IdsExample example);

    int updateByPrimaryKeySelective(Ids record);

    int updateByPrimaryKey(Ids record);
}