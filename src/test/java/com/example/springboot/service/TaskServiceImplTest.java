package com.example.springboot.service;

import com.example.springboot.domain.Task;
import com.example.springboot.repository.TaskRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceImplTest {

    @InjectMocks
    TaskServiceImpl taskService;

    @Mock
    TaskRepositoryImpl taskRepository;

    @Test
    public void createTaskSuccessfully_test() {
        Task expected = new Task();
        when(taskRepository.createTask(any())).thenReturn(expected);
        Task actual = taskService.createTask(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void readTaskSuccessfully_test() {
        Task expected = new Task();
        when(taskRepository.readTask(anyString())).thenReturn(expected);
        Task actual = taskService.readTask("1");
        assertEquals(expected, actual);
    }

    @Test
    public void updateTaskSuccessfully_test() {
        Task expected = new Task();
        when(taskRepository.updateTask(any())).thenReturn(expected);
        Task actual = taskService.updateTask(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void deleteTaskSuccessfully_test() {
        when(taskRepository.deleteTask(anyString())).thenReturn(Boolean.TRUE);
        Boolean actual = taskService.deleteTask("1");
        assertEquals(Boolean.TRUE, actual);
    }
}
