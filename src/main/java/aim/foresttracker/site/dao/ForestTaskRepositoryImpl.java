package aim.foresttracker.site.dao;

import aim.foresttracker.site.entities.ForestTask;
import aim.foresttracker.site.vo.ForestTaskVO;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 *
 */
@Repository
public class ForestTaskRepositoryImpl implements ForestTaskRepository {
    private volatile long TASK_ID_SEQUENCE = 4L;
    private static Map<Long, ForestTask> forestTaskDB = new LinkedHashMap<>();
    static {
        forestTaskDB.put(1L, new ForestTask(1L, "Description for the first task"));
        forestTaskDB.put(2L, new ForestTask(2L, "Description for the second task"));
        forestTaskDB.put(3L, new ForestTask(3L, "Description for the third task"));
    }

    @Override
    public List<ForestTask> getAll() {
        return new ArrayList<>(forestTaskDB.values());
    }

    @Override
    public ForestTask save(ForestTask task) {
        task.setId(getNextTaskId());
        forestTaskDB.put(task.getId(), task);
        return task;
    }

    private synchronized long getNextTaskId() {
        return TASK_ID_SEQUENCE++;
    }
}
