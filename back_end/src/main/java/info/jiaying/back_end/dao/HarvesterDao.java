package info.jiaying.back_end.dao;

import info.jiaying.back_end.model.HarvesterConf;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface HarvesterDao {
    @Insert("INSERT INTO `harvester_conf`(`user_id`, `path`) VALUES (#{user_id}, #{path})")
    void create(HarvesterConf conf);

    @Delete("DELETE FROM `harvester_conf` WHERE `user_id` = #{user_id} AND `path` = #{path}")
    void deleteByUserIdAndPath(HarvesterConf conf);

    @Delete("DELETE FROM `harvester_conf` WHERE `id` = #{id}")
    void deleteById(HarvesterConf conf);

    @Update("UPDATE `harvester_conf` SET `offset` = #{offset}, `path = `#{path} WHERE `id` = #{id}")
    void updateById(HarvesterConf conf);

    @Update("UPDATE `harvester_conf` SET `offset` = #{offset} WHERE `user_id` = #{user_id} AND `path` = #{path}")
    void updateOffsetByUserIdAbdPAth(HarvesterConf conf);

    @Select("select * from `harvester_conf` where `user_id` = #{userId}")
    List<HarvesterConf> get(int userId);

}
