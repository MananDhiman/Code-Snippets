# JUnit and Mockito for API
```java
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService service;

    @Test
    void greetingShouldReturnMessageFromService() throws Exception {
        when(service.greet()).thenReturn("Hello, Mock");
        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("Hello, Mock")));
    }

    @Test
    void testApi() {
        PostDTO postDTO = new PostDTO("New Post Test", 1L);

        MvcResult result = this.mockMvc.perform(post("/post/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(postDTO))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        int id = getPostId(result.getResponse().getContentAsString());

        this.mockMvc.perform(delete("/post/delete/" + id))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("Post Deleted"))
            .andReturn();
    }
}

public static String asJsonString(final Object obj) {
    try { return new ObjectMapper().writeValueAsString(obj); }
    catch (Exception e) { throw new RuntimeException(e); }
}
```
