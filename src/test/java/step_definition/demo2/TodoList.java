package step_definition.demo2;

public class TodoList {
    int total=3;
    public int getTotalTaskCount() {
        return total;
    }

    public void finishTask(int count) {
        this.total=total-count;
    }

    public int getRestTasksCount() {
        return total;
    }
}
