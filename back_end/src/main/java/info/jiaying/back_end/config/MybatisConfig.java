package info.jiaying.back_end.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"info.jiaying.back_end.dao"})
public class MybatisConfig {
}
