package edu.hbuas.campustodo.service;

import edu.hbuas.campustodo.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务应用服务。学生将在功能分支中逐步扩展该类。
 */
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    public Task addTask(String title) {
        Task task = new Task(nextId++, title);
        tasks.add(task);
        return task;
    }

    public List<Task> listAll() {
        return List.copyOf(tasks);
    }

    public void completeTask(long id) {
        Task task = tasks.stream()
                .filter(candidate -> candidate.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("任务不存在: " + id));

        if (task.isCompleted()) {
            throw new IllegalStateException("任务已经完成: " + id);
        }
        task.complete();
    }
}
