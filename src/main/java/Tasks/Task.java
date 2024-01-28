package Tasks;

public class Task {
    String taskName;
    Boolean isDone;
    String taskType;

    public Task(String taskName, Boolean isDone, String taskType) {
        this.taskName = taskName;
        this.isDone = isDone;
        this.taskType = taskType;
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        String done = " ";
        if (this.isDone) {
            done = "X";
        }
        return "[" + done + "] " + this.taskName;
    }

    public String getTaskType() {
        return this.taskType;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public Boolean getIsDone() {
        return this.isDone;
    }

    public String getDeadline() {
        return "";
    }

    public String getStart() {
        return "";
    }

    public String getEnd() {
        return "";
    }

}
