package cn.theproudsoul.fiscopetshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import util.Utils;

import javax.servlet.http.HttpSession;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
        String time = Utils.sdf(System.currentTimeMillis());
        System.out.println(time);
    }

    @Test
    public void testApplicant() throws Exception {
        mockMvc.perform(get("/applylist")).andDo(print())
                .andExpect(content().string(containsString("apply_list")));
    }

    @Test
    public void testLoginController() throws Exception {
        HttpSession session = mockMvc.perform(post("/login")
        .content("{\"type\":\"1\",\"user_name\":\"lhl\",\"password\":\"lhllhl\"}")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))//请求方式+地址
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.status", is("1")))
                .andReturn().getRequest().getSession();
        mockMvc.perform(get("/test").session((MockHttpSession) session)).andDo(print());
    }
}
