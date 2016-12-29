package aim.foresttracker.site.entities;

/**
 *
 */
public class ForestTask {
    private  Long id;
    private  String description;

    public ForestTask() {
    }

    public ForestTask(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
