package aim.foresttracker.site.dao;

import aim.foresttracker.site.entities.ForestTask;
import aim.foresttracker.site.vo.ForestTaskVO;

import java.util.List;

/**
 *
 */
public interface ForestTaskRepository {
    List<ForestTask> getAll();
    ForestTask save(ForestTask forestTask);
}
