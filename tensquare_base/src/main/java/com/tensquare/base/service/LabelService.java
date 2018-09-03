package com.tensquare.base.service;

import com.tensquare.base.dao.LabelRepository;
import com.tensquare.base.po.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import utils.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ye jiacheng
 * @create 2018-08-30
 */
@Service
public class LabelService {

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存一个标签
     *
     * @param label
     */
    public void saveLabel(Label label) {
        //设置ID
        label.setId(idWorker.nextId() + "");
        labelRepository.save(label);
    }

    /**
     * 更新一个标签
     *
     * @param label
     */
    public void updateLabel(Label label) {
        labelRepository.save(label);
    }

    /**
     * 删除一个标签
     *
     * @param id
     */
    public void deleteLabelById(String id) {
        labelRepository.deleteById(id);
    }

    /**
     * 查询全部标签
     *
     * @return
     */
    public List<Label> findLabelList() {
        return labelRepository.findAll();
    }

    /**
     * 根据ID查询标签
     *
     * @return
     */
    public Label findLabelById(String id) {
        return labelRepository.findById(id).get();
    }

    public List<Label> listBySpec(Map<String, Object> searchMap) {
        Specification<Label> specification = new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder
                    criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isEmpty(searchMap.get("labelname"))) {

                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + searchMap
                            .get("labelname") + "%");
                    predicates.add(predicate);

                }
                if (!StringUtils.isEmpty(searchMap.get("state"))) {
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), searchMap.get
                            ("state"));
                    predicates.add(predicate);

                }
                if (!StringUtils.isEmpty(searchMap.get("count"))) {
                    Predicate predicate = criteriaBuilder.equal(root.get("count").as(Long.class), searchMap.get
                            ("count"));
                    predicates.add(predicate);
                }
                if (!StringUtils.isEmpty(searchMap.get("recommend"))) {
                    Predicate predicate = criteriaBuilder.equal(root.get("recommend").as(String.class), searchMap.get
                            ("recommend"));
                    predicates.add(predicate);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return labelRepository.findAll(specification);
    }

    public Page<Label> listPageBySpec(Map<String, Object> searchMap, Integer page, Integer size) {

        Specification<Label> specification = new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                ArrayList<Predicate> predicates = new ArrayList<>();

                if (!StringUtils.isEmpty(searchMap.get("labelname"))) {

                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + searchMap
                            .get("labelname") + "%");
                    predicates.add(predicate);

                }
                if (!StringUtils.isEmpty(searchMap.get("state"))) {
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class), searchMap.get
                            ("state"));
                    predicates.add(predicate);

                }
                if (!StringUtils.isEmpty(searchMap.get("count"))) {
                    Predicate predicate = criteriaBuilder.equal(root.get("count").as(Long.class), searchMap.get
                            ("count"));
                    predicates.add(predicate);
                }
                if (!StringUtils.isEmpty(searchMap.get("recommend"))) {
                    Predicate predicate = criteriaBuilder.equal(root.get("recommend").as(String.class), searchMap.get
                            ("recommend"));
                    predicates.add(predicate);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return labelRepository.findAll(specification, PageRequest.of(page, size));
    }
}
