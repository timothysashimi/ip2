import Exceptions.InvalidInstructionException;
import Exceptions.MissingToDoNameException;
import Exceptions.MissingTaskToMarkException;

import java.util.Scanner;
import java.util.ArrayList;
public class Toothless {
    public static void main(String[] args) {
        Toothless.greet();
        Toothless.echo();
        Toothless.bye();
    }

    static void greet() {
        Toothless.printLines();
        System.out.println("Hello! I'm Toothless!\nWhat can I do for you?");
        Toothless.printLines();
    }

    static void bye() {
        Toothless.printLines();
        System.out.println("Bye. Hope to see you again soon!");
        Toothless.printLines();
    }

    static void echo() throws InvalidInstructionException {
        Scanner scanner = new Scanner(System.in);
        TaskList tasksList = new TaskList();
        String input = "";

        while (!input.equals("bye")) {
            input = scanner.nextLine();

            if (!input.equals("bye")) {
                if (input.equals("list")) {
                    System.out.println(tasksList.toString());

                } else if (input.contains("todo")) {
                    try {
                        if (input.split(" ").length == 1) {
                            throw new MissingToDoNameException("Please provide the description of the todo task :) Eg. 'Todo Chores'");
                        } else {
                            String name = input.substring(5);
                            String response = tasksList.add(new ToDo(name));
                            Toothless.printLines();
                            System.out.println(response);
                            Toothless.printLines();
                        }
                    } catch (MissingToDoNameException err) {
                        Toothless.printLines();
                        System.out.println(err.getMessage());
                        Toothless.printLines();
                    }


                } else if (input.contains("deadline")) {
                    int endChar = input.indexOf("/");
                    int startChar = 9;
                    String name = input.substring(9, endChar);
                    String deadline = input.substring(endChar + 4);
                    String response = tasksList.add(new Deadline(name, deadline));
                    Toothless.printLines();
                    System.out.println(response);
                    Toothless.printLines();

                } else if (input.contains("event")) {
                    int endChar = input.indexOf("/");
                    int endChar2 = input.indexOf("/", endChar + 1);
                    int startChar = 6;
                    String name = input.substring(6, endChar);
                    String startTime = input.substring(endChar + 5, endChar2);
                    String endTime = input.substring(endChar2 + 3);
                    String response = tasksList.add(new Event(name, startTime, endTime));
                    Toothless.printLines();
                    System.out.println(response);
                    Toothless.printLines();

                } else if (input.contains("unmark")) {
                    try {
                        if (input.split(" ").length == 1) {
                            throw new MissingTaskToMarkException("Please provide a task to unmark :)");

                        } else {
                            int index = Integer.parseInt(input.substring(7));
                            System.out.print(index);
                            String response = tasksList.unmark(index);
                            System.out.println(response);
                        }
                    } catch (MissingTaskToMarkException err) {
                        Toothless.printLines();
                        System.out.println(err.getMessage());
                        Toothless.printLines();
                    }

                } else if (input.contains("mark")) {
                    try {
                        if (input.split(" ").length == 1) {
                            throw new MissingTaskToMarkException("Please provide a task to mark :)");
                        } else {
                            int index = Integer.parseInt(input.substring(5));
                            System.out.print(index);
                            String response = tasksList.mark(index);
                            System.out.println(response);
                        }
                    } catch (MissingTaskToMarkException err) {
                        Toothless.printLines();
                        System.out.println(err.getMessage());
                        Toothless.printLines();
                    }


                } else if (input.contains("delete")){
                    int index = Integer.parseInt(input.substring(7));
                    System.out.print(index);
                    String response = tasksList.delete(index);
                    System.out.println(response);
                } else {
                    Toothless.printLines();
                    System.out.println("Try entering a valid instruction! Eg. 'Todo Chores' or 'Mark 2'");
                    Toothless.printLines();
                }

            } else {
                break;
            }

        }
    }

    static void printTasks(ArrayList<Task> tasksList) {
        int taskCount = 1;
        for (Task t : tasksList) {
            System.out.println(taskCount + ". " + t.toString());
            taskCount++;
        }
    }

    static void printLines() {
        System.out.println("____________________________________________________________");
    }

}
