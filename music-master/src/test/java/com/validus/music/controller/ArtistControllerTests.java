package com.validus.music.controller;

import com.validus.music.entity.Artist;
import com.validus.music.service.ArtistService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ArtistController.class)
public class ArtistControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ArtistService artistService;

    @Before
    public void setUp() {
        when(artistService.read(new Long(1)))
                .thenReturn(new Artist("Michael", null));
    }

    @Test
    public void readFirstArtist()
            throws Exception {

        this.mvc.perform(get("/artists/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Michael")));
    }

}
