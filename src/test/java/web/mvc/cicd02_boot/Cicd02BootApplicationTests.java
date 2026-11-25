package web.mvc.cicd02_boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class Cicd02BootApplicationTests {
    @Test
    void contextLoads() {
        log.info("----- 자동 배포 전 테스트 코드 실행 -----");
//        throw new RuntimeException("Fail!");
    }
}
