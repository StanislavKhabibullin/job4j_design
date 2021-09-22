package solid.isp.taskmenu;

import java.util.List;

public interface Menu {
    void put(Task task);
    List<Task> getMenu();

}
