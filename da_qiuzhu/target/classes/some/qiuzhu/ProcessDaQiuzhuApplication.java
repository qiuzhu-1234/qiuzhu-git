package some.qiuzhu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("some.qiuzhu")
public class ProcessDaQiuzhuApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessDaQiuzhuApplication.class, args);
    }
}
