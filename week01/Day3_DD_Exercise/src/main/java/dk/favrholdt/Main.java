package dk.favrholdt;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create a TaskList to hold tasks
        TaskList<Task> taskList = new TaskList<>();

        // Set due dates using LocalDate (Java Time API)
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate yesterday = today.minusDays(1);
        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate nextMonth = today.plusMonths(1);

        // Create instances of Task and GardenTask and add them to the TaskList
        taskList.addTask(new Task("Hent Bleer", "Størrelse 6 - REMA 1000", LocalDate.of(2024, 8, 25)));
        taskList.addTask(new Task("Betal Vuggestue regning", "Steiner Vuggely + tilmeld bs", LocalDate.now()));
        taskList.addTask(new Task("Oprydning i kælder", "Sorter ting i kasser", LocalDate.now().minusMonths(1)));
        taskList.addTask(new GardenTask("Fix trappetrin", "Det nederste trin er gået løs", tomorrow, "Ved teresse"));
        taskList.addTask(new GardenTask("Slå græs", "Lån græsslåmaskine af zaka", nextMonth, "Hele haven"));

        // Print all tasks
        System.out.println("Alle opgaver:");
        taskList.printTasks();
        System.out.println();

        // Filter tasks containing keyword
        System.out.println("Opgaver der indeholder 'Vuggestue':");
        List<Task> tasksContainingVuggestue = taskList.filterTasks("Vuggestue");
        tasksContainingVuggestue.forEach(System.out::println);
        System.out.println();

        // sort tasks by due date
        System.out.println("Opgaver sorteret efter forfaldsdato:");
        taskList.sortTasksByDueDate();
        taskList.printTasks();
        System.out.println();

        // Get tasks due today
        System.out.println("Dagens opgaver");
        List<Task> tasksDueToday = taskList.getTasksDueToday();
        tasksDueToday.forEach(System.out::println);
        System.out.println();

        // Get overdue tasks
        System.out.println("Opgaver der burde være blevet løst:");
        List<Task> overdueTasks = taskList.getOverdueTasks();
        overdueTasks.forEach(System.out::println);
        System.out.println();

        // Calculate and print how many days are left until each task's due date
        System.out.println("Antal dage til opgavens forfaldsdato:");
        taskList.forEach(task -> {
            long daysLeft = task.getDueDate().toEpochDay() - LocalDate.now().toEpochDay();
            System.out.println(task.getTitle() + " | " + daysLeft + " dage tilbage");
        });
    }
}