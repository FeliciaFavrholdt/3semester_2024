package dk.favrholdt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList<T extends Task> implements Iterable<T> {
    private List<T> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(T task) {
        tasks.add(task);
    }

    public List<T> filterTasks(String keyword) {
        return tasks.stream()
                .filter(task -> task.getTitle().contains(keyword) || task.getDescription().contains(keyword))
                .collect(Collectors.toList());
    }

    public void sortTasksByDueDate() {
        Collections.sort(tasks, (task1, task2) -> task1.getDueDate().compareTo(task2.getDueDate()));
    }

    public List<T> getTasksDueToday() {
        LocalDate today = LocalDate.now();
        return tasks.stream()
                .filter(task -> task.getDueDate().equals(today))
                .collect(Collectors.toList());
    }

    public List<T> getOverdueTasks() {
        LocalDate today = LocalDate.now();
        return tasks.stream()
                .filter(task -> task.getDueDate().isBefore(today))
                .collect(Collectors.toList());
    }

    public void printTasks() {
        tasks.forEach(System.out::println);
    }

    @Override
    public Iterator<T> iterator() {
        return tasks.iterator();
    }
}