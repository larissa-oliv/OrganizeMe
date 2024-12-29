package com.larissaoliveira;

import com.larissaoliveira.controller.TodoController;
import com.larissaoliveira.entity.Todo;
import com.larissaoliveira.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class OrganizeMeApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Mock
    private TodoService todoService;

    @InjectMocks
    private TodoController todoController;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void contextLoads() {
        // Test context loading
    }

    @Test
    void testCreateTodo() throws Exception {
        Todo todo = new Todo();
        todo.setNome("Estudar Spring Boot");
        todo.setDescricao("Estudar o framework Spring Boot");
        todo.setRealizado(false);
        todo.setPrioridade(1);

        lenient().when(todoService.create(any(Todo.class))).thenReturn(Collections.singletonList(todo));

        mockMvc.perform(post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Estudar Spring Boot\",\"descricao\":\"Estudar o framework Spring Boot\",\"realizado\":false,\"prioridade\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Estudar Spring Boot"));
    }

    @Test
    void testListTodos() throws Exception {
        Todo todo = new Todo();
        todo.setNome("Estudar Spring Boot");
        todo.setDescricao("Estudar o framework Spring Boot");
        todo.setRealizado(false);
        todo.setPrioridade(1);

        lenient().when(todoService.list()).thenReturn(Collections.singletonList(todo));

        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Estudar Spring Boot"));
    }
}