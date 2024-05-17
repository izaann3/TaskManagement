package taskmanagement;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;

class TaskManagement {
    File file = new File("/home/alumne/Escriptori/PB/uf4/taskmanagement/data.txt");

	HashMap<String, ArrayList<Task>> lists;
    HashMap<Integer, Task> tasks;

    public TaskManagement() {
        lists = new HashMap<String, ArrayList<Task>>();
        lists.put("Baja", new ArrayList<Task>());
        lists.put("Media", new ArrayList<Task>());
        lists.put("Alta", new ArrayList<Task>());
        tasks = new HashMap<Integer, Task>();
    }

    public void addTask(String taskName, String priority, String description, String dueDate) {
        Task task = new Task(taskName, priority, description, dueDate);
        lists.get(priority).add(task);
        tasks.put(task.getId(), task);
		savefileToFile();
    }

    public void doneTask(int taskId) {
        tasks.get(taskId).done();
		savefileToFile();
    }

    public void deleteTask(int taskId) {
        tasks.remove(taskId);
		savefileToFile();
    }

    public void printAllTask() {
        tasks.forEach((key, task) -> {
            System.out.println(task);
        });
    }

    public void printTaskByPriority(String priority) {
        System.out.println("Tareas de prioridad: " + priority);
        for (Task task : lists.get(priority)) {
            System.out.println(task);
        }
    }

	public void savefileToFile() {
		try (FileWriter writer = new FileWriter(file)) {
			writer.write("Esto es una prueba mia\n");
			for (Task task : tasks.values()) {
				writer.write(taskToFileString(task));
				System.out.println("Dades escrites al fitxer.");
			}
		} catch (IOException e) {
			System.out.println("S'ha produït un error en escriure al fitxer.");
			e.printStackTrace();
		}
	}
	
	private String taskToFileString(Task task) {
		return task.getId() + "," + task.getTitle() + "," + task.getPriority() + "," + task.getDescription() + "," + task.getDueDate() + "," + task.isDone();
	}
}

class Task {
    private static int numInstances = 0;
    private int id;
    private String title;
    private String priority;
    private String description;
    private String dueDate;
    private boolean isDone;

    public Task(String title, String priority, String description, String dueDate) {
        this.title = title;
        this.priority = priority;
        this.description = description;
        this.dueDate = dueDate;
        this.isDone = false;
        this.id = ++numInstances;
    }

    public void done() {
        this.isDone = true;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public String toString() {
        return "Id: " + id + "\nTitle: " + title + "\nPriority: " + priority + "\nDescription: " + description
                + "\nDue Date: " + dueDate + "\nIs Done: " + isDone;
    }
}
