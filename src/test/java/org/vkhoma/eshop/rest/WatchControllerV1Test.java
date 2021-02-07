package org.vkhoma.eshop.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.vkhoma.eshop.domain.Watch;
import org.vkhoma.eshop.service.impl.WatchServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WatchControllerV1.class)
class WatchControllerV1Test {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WatchServiceImpl watchService;

    @Test
    void postJsonObject_mediaTypeJson_statusCreated() throws Exception {
        Watch watch = new Watch();
        watch.setTitle("Prim");
        watch.setPrice(250000);
        watch.setDescription("A watch with a water fountain picture");
        watch.setFountain("R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=");

        String json = new ObjectMapper().writeValueAsString(watch);

        RequestBuilder request = MockMvcRequestBuilders.post("/api/v1/watch")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void postJsonObject_mediaTypeXml_statusBadRequest() throws Exception {
        Watch watch = new Watch();
        watch.setTitle("Prim");
        watch.setPrice(250000);
        watch.setDescription("A watch with a water fountain picture");
        watch.setFountain("R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=");

        String json = new ObjectMapper().writeValueAsString(watch);

        RequestBuilder request = MockMvcRequestBuilders.post("/api/v1/watch")
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .content(json);

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void postXmlObject_mediaTypeXml_statusCreated() throws Exception {
        Watch watch = new Watch();
        watch.setTitle("Prim");
        watch.setPrice(250000);
        watch.setDescription("A watch with a water fountain picture");
        watch.setFountain("R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=");

        String xml = new XmlMapper().writeValueAsString(watch);

        RequestBuilder request = MockMvcRequestBuilders.post("/api/v1/watch")
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .content(xml);

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

}