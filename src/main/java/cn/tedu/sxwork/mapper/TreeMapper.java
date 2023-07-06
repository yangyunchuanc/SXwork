package cn.tedu.sxwork.mapper;


import cn.tedu.sxwork.entity.Tree;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface TreeMapper {
    //添加树洞
    @Insert("insert into tree values(null,#{content},#{url}," +
            "#{nick},#{created},#{userId},#{price},#{number},#{goodName})")
    void insert(Tree tree);

    //查询所有树洞列表以时间降序
    @Select("select * from tree order by created desc")
    List<Tree> select();

    //根据id查询树洞
    @Select("select * from tree where id=#{id}")
    Tree selectById(int id);

    //查询树洞根据用户id
    @Select("select * from tree where userid=#{id}")
    List<Tree> selectByUserId(int id);

    //删除树洞根据id
    @Delete("delete from tree where id=#{id}")
    void deleteById(int id);

    @Update("update tree set number=#{i} where id=#{id}")
    void updateGoodNum(Integer i,Integer id);

    //删除所有数量为或小零的商品
    @Delete("delete from tree where number<=0")
    void deleteByZone();

}

