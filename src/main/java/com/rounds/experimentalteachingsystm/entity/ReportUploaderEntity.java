package com.rounds.experimentalteachingsystm.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * Description
 *
 * @author zhichenren
 * @version 1.0
 */
public class ReportUploaderEntity {
    private String studentId;
    private String name;
    private String intro;
    private String procedures;
    private String analysis;
    private MultipartFile[] images;

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getIntro() {
        return intro;
    }

    public String getProcedures() {
        return procedures;
    }

    public String getAnalysis() {
        return analysis;
    }

    public MultipartFile[] getImages() {
        return images;
    }
}
