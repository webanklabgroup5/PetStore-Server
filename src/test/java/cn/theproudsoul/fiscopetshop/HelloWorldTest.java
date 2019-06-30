package cn.theproudsoul.fiscopetshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //开启MockMvc
public class HelloWorldTest {

    @Autowired
    private MockMvc mockMvc; //注入MockMvc

    @Test
    public void testHelloController() throws Exception {

         mockMvc.perform(get("/")) //请求方式+地址
                .andDo(print()) //打印效果
                .andExpect(status().isOk()) //预期状态
                .andExpect(content().string(containsString("Hello World")));
    }

}