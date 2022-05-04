package com.rounds.experimentalteachingsystm.service;

import com.rounds.experimentalteachingsystm.entity.AucReport2Entity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author czy
 * @since 2022-01-08
 */
public interface AucReport2Service extends IService<AucReport2Entity> {
    void markdownToPdf(String studentId, String name, String intro, String procedures, String analysis, MultipartFile[] images) throws FileNotFoundException;
}
