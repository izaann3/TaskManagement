package taskmanagement;

import java.util.HashMap;
import java.util.ArrayList;

class TaskManagement {
	HashMap<String, ArrayList<Task>> lists;
	HashMap<Integer, Task> tasks;

	public TaskManagement() {
		lists = new HashMap<String, ArrayList<Task>>();
		lists.put("Baja", new ArrayList<Task>());
		lists.put("Media", new ArrayList<Task>());
		lists.put("Alta", new ArrayList<Task>());
		tasks = new HashMap<Integer, Task>();
	}

	public void addTask(String taskName, String priority) {
		Task task = new Task(taskName);
		lists.get(priority).add(task);
		tasks.put(task.getId(), task);
	}

	public void doneTask(int taskId) {
		tasks.get(taskId).done();
	}

	public void deleteTask(int taskId) {
		tasks.remove(taskId);
	}

	public void printAllTask() {
		tasks.forEach((key, task) -> {
			System.out.println(task);
		}
		);
	}

	public void printTaskByPriority(String priority) {
		System.out.println("Tareas de prioridad: " + priority);
		for (Task task: lists.get(priority)) {
			System.out.println(task);
		}
	}
}

class Task {
	private static int numInstances = 0;
	private int id;
	private String name;
	private boolean isDone;

	public Task(String name) {
		this.name = name;
		this.isDone = false;
		this.id = ++numInstances;
	}

	public void done() {
		this.isDone = true;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public boolean isDone() {
		return this.isDone;
	}

	public String toString() {
		return "Id:" + String.valueOf(id) + " Name: " + name + " Is done:" + String.valueOf(isDone);
	}
}