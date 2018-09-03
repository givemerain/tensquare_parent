package com.tensquare.base.web.controller;

import com.tensquare.base.po.Label;
import com.tensquare.base.service.LabelService;
import constants.StatusCode;
import dto.PageResultDTO;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ye jiacheng
 * @create 2018-08-30
 */
@RestController
@RequestMapping("label")
@CrossOrigin
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 新增
     *
     * @param label
     * @return
     */
    @PostMapping
    public ResultDTO add(@RequestBody Label label) {
        labelService.saveLabel(label);
        return new ResultDTO(true, StatusCode.ACCESSERROR, "保存成功");
    }

    /**
     * 修改编辑
     *
     * @param label
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResultDTO edit(@RequestBody Label label, @PathVariable String id) {
        label.setId(id);
        labelService.updateLabel(label);
        return new ResultDTO(true, StatusCode.OK, "修改成功");
    }

    /**
     * 根据id删除一个
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResultDTO remove(@PathVariable String id) {
        labelService.deleteLabelById(id);
        return new ResultDTO(true, StatusCode.OK, "删除成功");
    }

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping
    public ResultDTO list() {
        List<Label> list = labelService.findLabelList();
        return new ResultDTO(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 根据id查询一个
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResultDTO listById(@PathVariable String id) {
        Label label = labelService.findLabelById(id);
        return new ResultDTO(true, StatusCode.OK, "查询成功", label);
    }

    /**
     * 条件查询
     *
     * @param searchMap
     * @return
     */
    @PostMapping("/search")
    public ResultDTO listBySpec(@RequestBody Map<String, Object> searchMap) {
        List<Label> labels = labelService.listBySpec(searchMap);
        return new ResultDTO(true, StatusCode.OK, "查询成功", labels);
    }

    /**
     * 分页条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/search/{page}/{size}")
    public ResultDTO listPageBySpec(@RequestBody Map<String, Object> searchMap, @PathVariable Integer
            page, @PathVariable Integer size) {
        Page<Label> labels = labelService.listPageBySpec(searchMap, page, size);
        PageResultDTO pageResultDTO = new PageResultDTO<Label>(labels.getTotalElements(), labels.getContent());
        return new ResultDTO(true, StatusCode.OK, "查询成功", pageResultDTO);
    }
}
