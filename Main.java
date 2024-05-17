package taskmanagement;

class Main {
	public static void main(String[] args) {
		TaskManagement manager = new TaskManagement();
		System.out.println("Add task");
		manager.addTask("Tarea de GBD", "Alta");
		System.out.println("Hacemos Print de todo");
		manager.printAllTask();
		System.out.println("Hacemos Print de prioridad");
		manager.printTaskByPriority("Alta");
		System.out.println("Hacemos que la tarea este done");
		manager.doneTask(1);
		System.out.println("Hacemos Print de todo");
		manager.printAllTask();
		System.out.println("Eliminamos la tarea");
		manager.deleteTask(1);
		System.out.println("Hacemos Print de todo");
		manager.printAllTask();
	}
}
