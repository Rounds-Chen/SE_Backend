package com.rounds.experimentalteachingsystm;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

public class Generator {
    private static DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder("jdbc:mysql://106.14.97.109:3306/software_engineering","se","123456");


    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");

        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> {
                    builder.outputDir(projectPath + "/src/main/java")
                            .author("czy")
                            .dateType(DateType.TIME_PACK)
                            .commentDate("yyyy-MM-dd");
                })
                .packageConfig(builder -> {
                    builder.parent("com.rounds.experimentalteachingsystm")
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .controller("controller")
                            .other("other");
                })
                .templateConfig(builder -> {
                    builder .disable(TemplateType.ENTITY)
                            .entity("/templates/entity.java")
                            .service("/templates/service.java")
                            .serviceImpl("/templates/serviceImpl.java")
                            .mapper("/templates/mapper.java")
                            .controller("/templates/controller.java");
                })
                .strategyConfig(builder -> {
                    builder .entityBuilder()
                            .naming(NamingStrategy.underline_to_camel)
//                            .addTableFills(new Column("submit_time", FieldFill.INSERT))
                            .formatFileName("%sEntity")

                            .controllerBuilder()
                            .enableRestStyle()
                            .formatFileName("%sAction")

                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImp")

                            .mapperBuilder()
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .formatMapperFileName("%sMapper");
                })
                .templateEngine(new VelocityTemplateEngine()) // 默认的是Velocity引擎模板
                .execute();
    }
}
