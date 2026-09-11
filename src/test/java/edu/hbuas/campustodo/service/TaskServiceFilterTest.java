package edu.hbuas.campustodo.service;

import edu.hbuas.campustodo.model.Priority;
import edu.hbuas.campustodo.model.Task;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskServiceFilterTest {

    @Test
    void shouldFilterTasksByPriority() {
        TaskService service = new TaskService();
        Task highTask1 = service.addTask("高优先级任务1", Priority.HIGH);
        Task highTask2 = service.addTask("高优先级任务2", Priority.HIGH);
        Task mediumTask = service.addTask("中优先级任务", Priority.MEDIUM);
        Task lowTask = service.addTask("低优先级任务", Priority.LOW);

        List<Task> highTasks = service.filterByPriority(Priority.HIGH);

        assertEquals(2, highTasks.size());
        assertTrue(highTasks.contains(highTask1));
        assertTrue(highTasks.contains(highTask2));
    }

    @Test
    void shouldReturnEmptyListWhenNoTasksMatchPriority() {
        TaskService service = new TaskService();
        service.addTask("中优先级任务", Priority.MEDIUM);

        List<Task> highTasks = service.filterByPriority(Priority.HIGH);

        assertTrue(highTasks.isEmpty());
    }

    @Test
    void shouldReturnAllTasksWhenAllMatchPriority() {
        TaskService service = new TaskService();
        Task task1 = service.addTask("高优先级任务1", Priority.HIGH);
        Task task2 = service.addTask("高优先级任务2", Priority.HIGH);

        List<Task> highTasks = service.filterByPriority(Priority.HIGH);

        assertEquals(2, highTasks.size());
        assertTrue(highTasks.contains(task1));
        assertTrue(highTasks.contains(task2));
    }

    @Test
    void shouldReturnEmptyListWhenNoTasksExist() {
        TaskService service = new TaskService();

        List<Task> highTasks = service.filterByPriority(Priority.HIGH);

        assertTrue(highTasks.isEmpty());
    }
}
