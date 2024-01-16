package com.hua.mp.config;

import java.util.Collections;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 代码生成器
 */
public class MyFastAutoGenerator {
	public static void main(String[] args) {
		String outputPath = "/Users/lerry/Temp/MyBatisPlus";
		FastAutoGenerator.create("jdbc:mysql://localhost:3306/mp?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true"
				, "root", "root@0123")
				.globalConfig(builder -> {
					builder.author("lerry") // 设置作者
							//.enableSwagger() // 开启 swagger 模式
							.fileOverride() // 覆盖已生成文件
							.outputDir(outputPath); // 指定输出目录
				})
				.packageConfig(builder -> {
					builder.parent("com.hua") // 设置父包名
							.moduleName("mp") // 设置父包模块名
							.pathInfo(Collections.singletonMap(OutputFile.xml, outputPath)); // 设置mapperXml生成路径
				})
				.strategyConfig(builder -> {
					builder.addInclude("t_user", "ao_tag") // 设置需要生成的表名
							.addTablePrefix("t_", "c_"); // 设置过滤表前缀
				})
				// 使用Freemarker引擎模板，默认的是Velocity引擎模板
				.templateEngine(new FreemarkerTemplateEngine())
				.execute();

	}
}
