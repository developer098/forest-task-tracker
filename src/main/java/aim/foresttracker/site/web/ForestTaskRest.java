package aim.foresttracker.site.web;

import aim.foresttracker.site.service.ForestTaskService;
import aim.foresttracker.site.vo.ForestTaskVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("ftasks")
public class ForestTaskRest {

    private static final Logger logger = LogManager.getLogger();

    private ForestTaskService taskService;

    @Inject
    public ForestTaskRest(ForestTaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ForestTaskVO> readAll() {
        List<ForestTaskVO> allTasks = taskService.getAllTasks();
        return allTasks;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ForestTaskVO> createTask(@RequestBody ForestTaskVO taskVO) {
        taskService.saveTask(taskVO);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(taskVO.getId()).toUri();
        httpHeaders.setLocation(location);
        return new ResponseEntity<>(taskVO, httpHeaders, HttpStatus.CREATED);
    }

}
