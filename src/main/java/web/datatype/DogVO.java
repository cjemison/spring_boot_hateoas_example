package web.datatype;

public class DogVO {
    private Long id = null;
    private String name = null;

    protected DogVO(final Long id, final String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DogVO)) return false;

        DogVO dogVO = (DogVO) o;

        if (id != null ? !id.equals(dogVO.id) : dogVO.id != null) return false;
        return !(name != null ? !name.equals(dogVO.name) : dogVO.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DogVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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

        public DogVO build() {
            return new DogVO(this.id, this.name);
        }
    }
}
