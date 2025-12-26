package j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskManager<R, C extends Callable<R>>
        extends ArrayList<TaskItem<R, C>> {
    private ExecutorService exec =
            Executors.newCachedThreadPool();

    public void add(C task) {
        add(new TaskItem<R, C>(exec.submit(task), task));
    }

    public java.util.List<R> getResults() {
        Iterator<TaskItem<R, C>> items = iterator();
        java.util.List<R> results = new ArrayList<R>();
        while (items.hasNext()) {
            TaskItem<R, C> item = items.next();
            if (item.future.isDone()) {
                try {
                    results.add(item.future.get());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                items.remove();
            }
        }
        return results;
    }

    public java.util.List<String> purge() {
        Iterator<TaskItem<R, C>> items = iterator();
        java.util.List<String> results = new ArrayList<String>();
        while (items.hasNext()) {
            TaskItem<R, C> item = items.next();
// Сохранить завершенные задачи для вывода
// информации о результатах:
            if (!item.future.isDone()) {
                results.add("Cancelling " + item.task);
                item.future.cancel(true); // Возможно прерывание
                items.remove();
            }
        }
        return results;
    }
}
