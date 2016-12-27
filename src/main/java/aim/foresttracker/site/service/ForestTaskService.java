package aim.foresttracker.site.service;

import aim.foresttracker.site.vo.ForestTaskVO;

import java.util.List;

/**
 *
 */
public interface ForestTaskService {
    List<ForestTaskVO> getAllTasks();
    void saveTask(ForestTaskVO taskVO);
}
