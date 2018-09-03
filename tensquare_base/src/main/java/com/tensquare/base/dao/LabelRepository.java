package com.tensquare.base.dao;

import com.tensquare.base.po.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ye jiacheng
 * @create 2018-08-30
 */
public interface LabelRepository extends JpaRepository<Label,String>,JpaSpecificationExecutor<Label>{
}
