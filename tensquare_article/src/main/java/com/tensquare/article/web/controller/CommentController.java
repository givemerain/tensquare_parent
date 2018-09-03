package com.tensquare.article.web.controller;

import com.tensquare.article.po.Comment;
import com.tensquare.article.service.CommentService;
import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ye jiacheng
 * @create 2018-09-03
 */
@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResultDTO save(@RequestBody Comment comment) {
        commentService.add(comment);
        return new ResultDTO(true, StatusCode.OK, "添加成功");
    }

    @GetMapping("/article/{articleid}")
    public ResultDTO findByArticleid(@PathVariable String articleid) {
        return new ResultDTO(true,StatusCode.OK,"查询成功",commentService.findByArticleid(articleid));
    }
}
