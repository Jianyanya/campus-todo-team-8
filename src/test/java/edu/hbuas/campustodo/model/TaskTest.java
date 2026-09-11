package edu.hbuas.campustodo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskTest {

    @Test
    void shouldDefaultPriorityBeMedium() {
        Task task = new Task(1L, "默认优先级任务");

        assertEquals(Priority.MEDIUM, task.getPriority());
    }

    @Test
    void shouldCreateTaskWithSpecifiedPriority() {
        Task task = new Task(1L, "高优先级任务", Priority.HIGH);

        assertEquals(Priority.HIGH, task.getPriority());
    }

    @Test
    void shouldRejectNullPriorityInConstructor() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task(1L, "任务", null));
    }

    @Test
    void shouldUpdatePriority() {
        Task task = new Task(1L, "任务");

        task.setPriority(Priority.HIGH);

        assertEquals(Priority.HIGH, task.getPriority());
    }

    @Test
    void shouldRejectNullPriorityInSetter() {
        Task task = new Task(1L, "任务");

        assertThrows(IllegalArgumentException.class,
                () -> task.setPriority(null));
    }
}
