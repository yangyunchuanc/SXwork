package cn.tedu.sxwork.controller;

import cn.tedu.sxwork.entity.Comment;
import cn.tedu.sxwork.entity.Tree;
import cn.tedu.sxwork.entity.User;
import cn.tedu.sxwork.mapper.CommentMapper;
import cn.tedu.sxwork.mapper.TreeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CommentController {
    @Autowired(required = false)
    CommentMapper mapper;
    @Autowired(required = false)
    TreeMapper treeMapper;

    @RequestMapping("/comment/insert")
    public int insert(@RequestBody Comment comment, HttpSession session){
        System.out.println("comment = " + comment );
        User u = (User) session.getAttribute("u");
        if (u==null){//代表未登录
            return 2;
        }
        //把当前登录的用户信息添加到评论对象里面
        comment.setNick(u.getNick());
        comment.setGoodName(treeMapper.selectById(comment.getTreeId()).getGoodName());
        mapper.insert(comment);
        return 1;//代表评论成功!
    }

    @ResponseBody
    @RequestMapping("/comment/select")
    public List<Comment> select(int id){
        return mapper.selectByTreeId(id);
    }

    @RequestMapping("/selectcomment")
    public List<Comment> selectcomment(){
        return mapper.select();
    }
}
