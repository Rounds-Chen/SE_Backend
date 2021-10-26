package com.rounds.experimentalteachingsystm.controller;


import com.rounds.experimentalteachingsystm.entity.ExperimentEntity;
import com.rounds.experimentalteachingsystm.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2021-10-25
 */
@RestController
@RequestMapping("//experiment-entity")
public class ExperimentAction {
//    @Resource
//    ExperimentService experimentService;

    @Autowired
    ExperimentService experimentService;

    @RequestMapping("/experList")
    List<ExperimentEntity> test(){
        return experimentService.list();
    }

}

