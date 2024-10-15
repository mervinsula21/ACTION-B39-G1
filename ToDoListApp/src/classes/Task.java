package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Task {
    private static int idCounter = 1;
    private int id;
    private String description;
    private LocalDate deadline; // Changed from String to LocalDate
    private boolean isCompleted;
    private String priority;

    public Task(String description, String priority, String deadline) {
        this.id = idCounter++;
        this.description = description;
        setDeadline(deadline); // Updated to call the new setDeadline method
        this.priority = priority;
        this.isCompleted = false;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() { // Changed return type from String to LocalDate
        return deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // Method to set the deadline with validation
    public void setDeadline(String deadline) {
    	try {
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    		this.deadline = LocalDate.parse(deadline, formatter);
    	} catch (DateTimeParseException e) {
    		System.out.println("Invalid date format. Please use 'yyyy-MM-dd'.");
    		this.deadline = null;
    	}
    }

    @Override
    public String toString() {
        return "Task ID: " + id +
               ", Description: " + description +
                ", Deadline: " + (deadline != null ? deadline : "Not set") +
                ", Completed: " + (isCompleted ? "Yes" : "No") +
               ", Priority " + priority;
    }

    public String getPriority() {
        return priority;
    }
}