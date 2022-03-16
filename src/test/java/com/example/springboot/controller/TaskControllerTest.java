package com.example.springboot.controller;

import com.example.springboot.domain.Task;
import com.example.springboot.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TaskService taskService;

    @Test
    void createTaskSuccessfully_test() throws Exception {
        when(taskService.createTask(any())).thenReturn(new Task());
        this.mockMvc.perform(post("/api/v1/task/").contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"1\",\"description\":\"first task\"}"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void readTaskSuccessfully_test() throws Exception {
        when(taskService.readTask(any())).thenReturn(new Task());
        this.mockMvc.perform(get("/api/v1/task/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updateTaskSuccessfully_test() throws Exception {
        when(taskService.updateTask(any())).thenReturn(new Task());
        this.mockMvc.perform(put("/api/v1/task/").contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"1\",\"description\":\"first task\"}"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void deleteTaskSuccessfully_test() throws Exception {
        when(taskService.deleteTask(any())).thenReturn(Boolean.TRUE);
        this.mockMvc.perform(delete("/api/v1/task/1"))
                .andDo(print()).andExpect(status().isOk());
    }

}
