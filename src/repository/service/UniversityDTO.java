package repository.service;

public class UniversityDTO {
    private String name;
    private Integer counter;
    private String description;
    private String info;

    public UniversityDTO() {
    }

    public UniversityDTO(String name, Integer counter, String description, String info) {
        this.name = name;
        this.counter = counter;
        this.description = description;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "UniversityDTO{" +
                "name='" + name + '\'' +
                ", counter=" + counter +
                ", description='" + description + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
