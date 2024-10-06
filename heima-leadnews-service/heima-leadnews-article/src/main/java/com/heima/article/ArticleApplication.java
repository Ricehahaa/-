package com.heima.article;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.heima.apis")
@MapperScan("com.heima.article.mapper")
public class ArticleApplication {

    public static void main(String[] args) {
        //ArticleApplication.main1();
        SpringApplication.run(ArticleApplication.class,args);
    }

    public static void main1() {

        FileInputStream fileInputStream = null;
        try {

            fileInputStream =  new FileInputStream("D:\\BaiduNetdiskDownload\\heima\\moban\\plugins\\js\\index.js");;

            //1.创建minio链接客户端
            MinioClient minioClient = MinioClient.builder().credentials("minio", "minio123").endpoint("http://192.168.169.3:9000").build();
            //2.上传
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object("plugins/js/index.js")//文件名
                    .contentType("text/js")//文件类型
                    .bucket("leadnews")//桶名词  与minio创建的名词一致
                    .stream(fileInputStream, fileInputStream.available(), -1) //文件流
                    .build();
            minioClient.putObject(putObjectArgs);

            System.out.println("http://192.168.169.3:9000");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * mybatis-plus分页支持
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
