package com.tensquare.article.dao;

import com.tensquare.article.po.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author ye jiacheng
 * @create 2018-09-03
 */
public interface CommentRepository extends MongoRepository<Comment, String> {

    /**    
      * 根据文章ID查询评论列表    
      * @param articleid    
      * @return    
      */
    List<Comment> findCommentByArticleid(String id);
}
