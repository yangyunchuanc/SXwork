package cn.tedu.sxwork.mapper;


import cn.tedu.sxwork.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    //通过用户查询密码,且将密码封装到User对象中
    @Select("select * from user where username=#{username}")
    User selectByUsername(String username);

    //注册
    @Insert("insert into user values(null,#{username},#{password},#{nick},0)")
    void insert(User user);

    //更新钱包
    @Update("update user set purse=#{i} where id=#{id}")
    void trade(float i,Integer id);

    @Select("select * from user where id=#{id}")
    User selectById(int id);
}



