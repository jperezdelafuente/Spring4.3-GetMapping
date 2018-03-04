package com.example.getmapping.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PersonControllerTest {

    private PersonController personController;

    @Before
    public void setUp() throws Exception {
        personController = new PersonController();
    }

    @Test
    public void testPersonGetMapping() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        String url = "/personGetMapping";
        String name = "Pepe";
        String surname = "Garcia";

        mockMvc.perform(get(url).param("name", name).param("surname", surname))
                .andExpect(status().isOk())
                .andExpect(view().name("person-view"))
                .andExpect(model().attributeExists("person"))
                .andExpect(request().attribute("person", hasProperty("name", equalToIgnoringCase(name))))
                .andExpect(request().attribute("person", hasProperty("surname", equalToIgnoringCase(surname))));
    }

    @Test
    public void testPersonGetMappingById() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        String url = "/personGetMappingById";
        String id = "1";
        String name = "Pepe";
        String surname = "Garcia";

        mockMvc.perform(get(url).param("id", id))
                .andExpect(status().isOk())
                .andExpect(view().name("person-view"))
                .andExpect(model().attributeExists("person"))
                .andExpect(request().attribute("person", hasProperty("id", equalTo(id))))
                .andExpect(request().attribute("person", hasProperty("name", equalToIgnoringCase(name))))
                .andExpect(request().attribute("person", hasProperty("surname", equalToIgnoringCase(surname))));
    }

    @Test
    public void testPersonGetMappingPath() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        String id = "1";
        String url = "/personGetMappingPath/" + id;
        String name = "Pepe";
        String surname = "Garcia";

        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(view().name("person-view"))
                .andExpect(model().attributeExists("person"))
                .andExpect(request().attribute("person", hasProperty("id", equalTo(id))))
                .andExpect(request().attribute("person", hasProperty("name", equalToIgnoringCase(name))))
                .andExpect(request().attribute("person", hasProperty("surname", equalToIgnoringCase(surname))));
    }

    @Test
    public void testPersonRequestMapping() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        String url = "/personRequestMapping";
        String name = "Pepe";
        String surname = "Garcia";

        mockMvc.perform(get(url).param("name", name).param("surname", surname))
                .andExpect(status().isOk())
                .andExpect(view().name("person-view"))
                .andExpect(model().attributeExists("person"))
                .andExpect(request().attribute("person", hasProperty("name", equalToIgnoringCase(name))))
                .andExpect(request().attribute("person", hasProperty("surname", equalToIgnoringCase(surname))));
    }

    @Test
    public void testPersonRequestMappingById() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        String url = "/personRequestMappingById";
        String id = "1";
        String name = "Pepe";
        String surname = "Garcia";

        mockMvc.perform(get(url).param("id", id))
                .andExpect(status().isOk())
                .andExpect(view().name("person-view"))
                .andExpect(model().attributeExists("person"))
                .andExpect(request().attribute("person", hasProperty("id", equalTo(id))))
                .andExpect(request().attribute("person", hasProperty("name", equalToIgnoringCase(name))))
                .andExpect(request().attribute("person", hasProperty("surname", equalToIgnoringCase(surname))));
    }

    @Test
    public void testPersonRequestMappingPath() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        String id = "1";
        String url = "/personRequestMappingPath/" + id;
        String name = "Pepe";
        String surname = "Garcia";

        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(view().name("person-view"))
                .andExpect(model().attributeExists("person"))
                .andExpect(request().attribute("person", hasProperty("id", equalTo(id))))
                .andExpect(request().attribute("person", hasProperty("name", equalToIgnoringCase(name))))
                .andExpect(request().attribute("person", hasProperty("surname", equalToIgnoringCase(surname))));
    }

}