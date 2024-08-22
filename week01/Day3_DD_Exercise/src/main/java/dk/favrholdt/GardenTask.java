package dk.favrholdt;

import java.time.LocalDate;

public class GardenTask extends Task {

    private String gardenLocation;

    public GardenTask(String title, String description, LocalDate dueDate, String gardenLocation) {
        super(title, description, dueDate);
        this.gardenLocation = gardenLocation;
    }

    public String getGardenLocation() {
        return gardenLocation;
    }

    @Override
    public String toString() {
        return super.toString() + " | Lokation: " + gardenLocation;
    }
}