package solid.isp.taskMenu;

import java.util.List;

public interface Menu {
    void put(Task task);
    List<Task> getMenu();

}
