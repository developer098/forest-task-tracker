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
    private volatile long TASK_ID_SEQUENCE = 1L;
    private Map<Long, ForestTask> forestTaskDB = new LinkedHashMap<>();

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
