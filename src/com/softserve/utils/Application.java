package com.softserve.utils;

import com.softserve.Task;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import static com.softserve.utils.ConsoleUtils.getInt;
import static com.softserve.utils.FileUtils.*;
public class Application {
    public static List<Task> tasksList;
    public static List<Task> deletedTasksList;

    static void createTask() {
        Task task;
        while (true) {
        System.out.println("Choose way of creating. Enter number:\n" +
                "1 - Fast way - in one line\n" +
                "2 - Usual way - step by step\n"+
                "-1 - Go back to main menu");
        int priority = ConsoleUtils.getInt();
        switch (priority == 1) {
            case 1:
                task = createTaskInOneLine();
                break;
            case 2:
                task = createTaskStepByStep();
                break;
            case -1:
                 break;
        }
    }

    static void createTaskInOneLine(){
        while (true) {
            System.out.println("For creating task enter data according to this pattern, please!\n" +
                    "Task construction:  Task title!type Personal or Work or Household!number of priority 1 - High, 2 - Medium, 3 - Low!datetime dd-MM-yyyy HH:mm\n" +
                    "Task example: Come to the DEMO!Work!1!15-10-2021 19:00\n" +
                    "-1 - Go back");
            String TaskInOneLine = ConsoleUtils.getString();
            if (TaskInOneLine.equals("-1")) {
                break;
            }
            System.out.println("Confirm this task: " + TaskInOneLine);
            System.out.println("Task successfully created");
        }
        tasksList.add(0, task);
    }

    static void createTaskStepByStep() {
        while (true) {
            System.out.println("For creating task enter task title, please!\n" +
                    "-1 - Go back");
            String title = ConsoleUtils.getString();
            if(title.equals("-1")) {
                break;
            }
            System.out.println("Enter a type of task, please: Personal or Work or Household.\n" +
                    "-1 - Go back");
            String type = ConsoleUtils.getString();
            if(type.equals("-1")){
                break;
            }
            System.out.println("Enter task priority. Choose task priority and write number of it, please: 1 -High, 2 - Medium, 3 - Low\n" +
                    "-1 - Go back");
            int priority = ConsoleUtils.getInt();
            if (priority==-1){
                break;
            }
            System.out.println("Enter date and time dd-MM-yyyy HH:mm.\n" +
                    "-1 - Go back");
            String dateTime = ConsoleUtils.getString();
            if(dateTime.equals("-1")){
                break;
            }
            System.out.println("Confirm this task:" + title + type + priority + dateTime);
            LocalDateTime dateTimeNew = parseFromString(dateTime);
            return new Task(title, type, priority, dateTimeNew);
        }
        tasksList.add(0, task);
    }


    static void editTask() {
        //TO DO
    }

    static void deleteTask() {
        //TO DO
    }

    static void viewTasks() {
        //TO DO
    }

    public static void main(String[] args) {
        createIfNotExists(taskFileName);
        readFile(taskFileName);

        createIfNotExists(deletedTaskFileName);
        readFile(deletedTaskFileName);

        int option = 1;
        while (option != 0) {
            System.out.println("Main menu. Choose option:");
            System.out.println("1 - Create task");
            System.out.println("2 - Edit task");
            System.out.println("3 - Delete task");
            System.out.println("4 - View tasks");
            System.out.println("0 - Exit");
            option = getInt();
            switch (option) {
                case 1:
                    createTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    viewTasks();
                    break;
                case 0:
                    System.out.println("Good bye");
            }
        }
    }
}
