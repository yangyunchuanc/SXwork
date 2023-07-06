package cn.tedu.sxwork.mapper;

import cn.tedu.sxwork.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("insert into comment values(null,#{content},#{nick},#{treeId},#{goodName})")
    void insert(Comment comment);

    @Select("select * from comment where treeid=#{treeId}")
    List<Comment> selectByTreeId(int treeId);

    @Select("select * from comment")
    List<Comment> select();
}
