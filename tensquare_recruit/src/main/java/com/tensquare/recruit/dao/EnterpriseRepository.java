package com.tensquare.recruit.dao;

import com.tensquare.recruit.po.Enterprise;
import com.tensquare.recruit.po.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface EnterpriseRepository extends JpaRepository<Enterprise,String>,JpaSpecificationExecutor<Enterprise>{

    /**
     * 根据热门状态获取企业列表
     * @param isHot
     * @return
     */
    List<Enterprise> findByIshot(String isHot);


}
