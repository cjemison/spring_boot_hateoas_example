package persistence.datatype;


public class DogBO {
    private Long id = null;
    private String name = null;

    protected DogBO() {

    }

    protected DogBO(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder {
        private Long id = null;
        private String name = null;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public DogBO build() {
            return new DogBO(this.id, this.name);
        }
    }
}
