package com.shuang.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {

    //配置了swagger的docket的bean实例
    //core.env结尾的
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
    @Bean
    public Docket docket4(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("D");
    }




    @Bean
    public Docket docket(Environment environment){

        //设置要显示的Swagger环境
        Profiles profiles=Profiles.of("dev","test");

        //获取项目的环境
        //通过environment.acceptsProfiles判断是否处于自己设置的环境中。
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)//enable是否启动Swagger,如果为false,则Swagger不能在浏览器中访问。
                .select()
                //RequestHandlerSelectors，配置要扫描接口的方式
                //basePackage:指定要扫描的包
                //any():扫描全部
                //none():不扫描
                //withclassAnnotation:扫描类上的注解
                .apis(RequestHandlerSelectors.basePackage("com.shuang.controller"))
                //paths()，过滤什么路径
               //.paths(PathSelectors.ant("/shuang/"))
                .build();
    }

    //配置swagger信息apiInfo
    private ApiInfo apiInfo() {

        Contact contack=new Contact("江爽","https://www.shishuangzhi.xyz","2894247242@qq.com");

        return new ApiInfo(
                "爽宝的Swagger API文档",
                "看到这个demo的人，能教我追妹子吗，有偿，微信号：js13617293003",
                "1.0",
                "https://www.shishuangzhi.xyz",
                contack,
                "Apache 2.0",
                "http://www.apache.org/license/LICENSE-2.0",
                 new ArrayList()
        );

    }






}
