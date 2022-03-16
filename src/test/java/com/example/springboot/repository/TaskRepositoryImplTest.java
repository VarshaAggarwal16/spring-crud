package com.example.springboot.repository;

import com.example.springboot.domain.Task;
import com.example.springboot.repository.mongodb.TaskMongoDBRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskRepositoryImplTest {

    @InjectMocks
    TaskRepositoryImpl taskRepository;

    @Mock
    TaskMongoDBRepository taskMongoDBRepository;

    @Test
    public void createTaskSuccessfully_test() {
        Task expected = new Task();
        when(taskMongoDBRepository.save(any())).thenReturn(expected);
        Task actual = taskRepository.createTask(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void readTaskSuccessfully_test() {
        Task expected = new Task();
        when(taskMongoDBRepository.findById(anyString())).thenReturn(Optional.of(expected));
        Task actual = taskRepository.readTask("1");
        assertEquals(expected, actual);
    }

    @Test
    public void updateTaskSuccessfully_test() {
        Task expected = new Task();
        when(taskMongoDBRepository.save(any())).thenReturn(expected);
        Task actual = taskRepository.createTask(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void deleteTaskSuccessfully_test() {
        doNothing().when(taskMongoDBRepository).deleteById(anyString());
        Boolean actual = taskRepository.deleteTask("1");
        assertEquals(Boolean.TRUE, actual);
    }
}
