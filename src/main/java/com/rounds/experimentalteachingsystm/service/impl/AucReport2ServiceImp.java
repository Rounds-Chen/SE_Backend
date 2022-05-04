package com.rounds.experimentalteachingsystm.service.impl;

import com.aliyun.oss.OSS;
import com.rounds.experimentalteachingsystm.entity.AucReport2Entity;
import com.rounds.experimentalteachingsystm.mapper.AucReport2Mapper;
import com.rounds.experimentalteachingsystm.service.AucReport2Service;
import com.rounds.experimentalteachingsystm.util.OSSUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youbenzi.md2.export.FileFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czy
 * @since 2022-01-08
 */
@Service
public class AucReport2ServiceImp extends ServiceImpl<AucReport2Mapper, AucReport2Entity> implements AucReport2Service {
    @Override
    public void markdownToPdf(String studentId, String name, String intro, String procedures, String analysis, MultipartFile[] images) throws FileNotFoundException {
        List<String> paths = new ArrayList<String>();

        for(int i=0;i<images.length;i++){
            String path = studentId + "_" + i;
            paths.add(OSSUtil.uploadFile(images[i], path));
        }
        StringBuilder context = new StringBuilder("### 拍卖实验\n\n" + studentId + "    " + name + "\n\n"
                + "#### 实验介绍\n\n" + intro + "\n\n" + "#### 实验步骤记录\n\n"
                + procedures + "\n\n");
        for(int i=0;i<paths.size();i++) {
            context.append("![](").append(paths.get(i)).append(")\n\n");
        }


        context.append("#### 实验结果分析\n\n").append(analysis);
        FileFactory.produce(context.toString(), studentId + "_" + name + ".pdf");

    }
}
