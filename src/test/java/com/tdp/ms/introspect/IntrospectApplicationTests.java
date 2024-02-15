package com.tdp.ms.introspect;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IntrospectApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void main() {
        IntrospectApplication.main(new String[] {});
    }

}
