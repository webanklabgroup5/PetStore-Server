package cn.theproudsoul.fiscopetshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import util.Utils;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //开启MockMvc
public class UserTest {
    @Autowired
    private MockMvc mockMvc; //注入MockMvc

    @Test
    public void testTime() throws Exception{
        long now=System.currentTimeMillis();
        String time = Utils.sdf(now);
        System.out.println(time);
    }

    @Test
    public void testLoginController() throws Exception {

        mockMvc.perform(post("/login")
        .content("{\"type\":\"1\",\"user\":\"TheProudSoul\",\"passwd\":\"zyj971213\"}")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))//请求方式+地址
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.status", is("0")));
    }
}
