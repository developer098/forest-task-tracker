package aim.foresttracker.site.vo;

/**
 *
 */
public class ForestTaskVO {
    private  Long id;
    private  String description;

    public ForestTaskVO() {
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ForestTaskVO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
