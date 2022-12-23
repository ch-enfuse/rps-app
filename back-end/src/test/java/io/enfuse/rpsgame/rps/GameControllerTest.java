package io.enfuse.rpsgame.rps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.enfuse.rpsgame.domain.GameRequest;
import io.enfuse.rpsgame.domain.RPSOptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void play() throws Exception{
            mockMvc.perform(post("/play")
                            .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(new GameRequest("testplayr",RPSOptions.ROCK))))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.gameResult").value("TIE"))
                    .andExpect(jsonPath("$.playerOption").value("ROCK"))
                    .andExpect(jsonPath("$.computerOption").value("ROCK"));
    }

}
