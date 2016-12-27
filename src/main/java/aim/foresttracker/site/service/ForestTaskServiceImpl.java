package aim.foresttracker.site.service;

import aim.foresttracker.site.dao.ForestTaskRepository;
import aim.foresttracker.site.entities.ForestTask;
import aim.foresttracker.site.vo.ForestTaskVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class ForestTaskServiceImpl implements ForestTaskService {

    private ForestTaskRepository taskRepository;

    private static final Logger logger = LogManager.getLogger();

    @Inject
    public ForestTaskServiceImpl(ForestTaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<ForestTaskVO> getAllTasks() {
        List<ForestTask> tasks = taskRepository.getAll();
        List<ForestTaskVO> taskVOs = new ArrayList<>(tasks.size());
        tasks.forEach(t -> taskVOs.add(convert(t)));
        return taskVOs;
    }

    @Override
    public void saveTask(ForestTaskVO taskVO) {
        ForestTask task = new ForestTask();
        task.setId(taskVO.getId());
        task.setDescription(taskVO.getDescription());
        taskRepository.save(task);
        if (taskVO.getId() == null) {
            taskVO.setId(task.getId());
        }
    }

    private ForestTaskVO convert(ForestTask task) {
        ForestTaskVO taskVO = new ForestTaskVO();
        taskVO.setId(task.getId());
        taskVO.setDescription(task.getDescription());
        return taskVO;
    }
}
