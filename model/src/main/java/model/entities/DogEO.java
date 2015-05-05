package model.entities;


import javax.persistence.*;

@Entity
@Table(name = "dog_tbl")
public class DogEO {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;

    @Basic(optional = false)
    @Column(name = "name")
    private String name = "";

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
        if (!(o instanceof DogEO)) return false;

        DogEO dogEO = (DogEO) o;

        if (id != null ? !id.equals(dogEO.id) : dogEO.id != null) return false;
        return !(name != null ? !name.equals(dogEO.name) : dogEO.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DogEO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
