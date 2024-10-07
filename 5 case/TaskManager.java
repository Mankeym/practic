import java.util.Scanner;
public class TaskManager {
    private TaskList taskList;


    
    public TaskManager() {
        taskList = new TaskList();
    }

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Отобразить задачи");
            System.out.println("4. Сохранить задачи в файл");
            System.out.println("5. Загрузить задачи из файла");
            System.out.println("6. Выход");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    removeTask(scanner);
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    saveToFile(scanner);
                    break;
                case 5:
                    loadFromFile(scanner);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный выбор");
            }
        }
    }

    private void addTask(Scanner scanner) {
        System.out.print("Введите описание задачи: ");
        String description = scanner.next();
        Task task = new Task(description);
        taskList.addTask(task);
    }

    private void removeTask(Scanner scanner) {
        System.out.print("Введите описание задачи для удаления: ");
        String description = scanner.next();
        Task task = findTask(description);
        if (task != null) {
            taskList.removeTask(task);
        } else {
            System.out.println("Задача не найдена");
        }
    }

    private Task findTask(String description) {
        for (Task task: taskList.tasks) {
            if (task.getDescription().equals(description)) {
                return task;
            }
        }
        return null;
    }

    private void displayTasks() {
        taskList.displayTasks();
    }

    private void saveToFile(Scanner scanner) {
        System.out.print("Введите имя файла для сохранения: ");
        String fileName = scanner.next();
        taskList.saveToFile(fileName);
    }

    private void loadFromFile(Scanner scanner) {
        System.out.print("Введите имя файла для загрузки: ");
        String fileName = scanner.next();
        taskList.loadFromFile(fileName);
    }
}