package dk.favrholdt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private String title;
    private String description;
    private LocalDate dueDate;

/*    public Task(String title, String description, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }*/

    @Override
    public String toString() {
        return "* " + title + " | " + description + " | Forfaldsdato: " + dueDate;
    }
}