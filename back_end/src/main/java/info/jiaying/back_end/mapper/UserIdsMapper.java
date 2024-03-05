package info.jiaying.back_end.mapper;

import info.jiaying.back_end.model.UserIds;
import info.jiaying.back_end.model.UserIdsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserIdsMapper {
    long countByExample(UserIdsExample example);

    int deleteByExample(UserIdsExample example);

    int deleteByPrimaryKey(Integer userIdsId);

    int insert(UserIds record);

    int insertSelective(UserIds record);

    List<UserIds> selectByExample(UserIdsExample example);

    UserIds selectByPrimaryKey(Integer userIdsId);

    int updateByExampleSelective(@Param("record") UserIds record, @Param("example") UserIdsExample example);

    int updateByExample(@Param("record") UserIds record, @Param("example") UserIdsExample example);

    int updateByPrimaryKeySelective(UserIds record);

    int updateByPrimaryKey(UserIds record);
}