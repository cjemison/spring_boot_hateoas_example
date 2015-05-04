package model.entities;


import javax.persistence.*;

@Entity
@Table(name = "dog_tbl")
public class Dog {
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id = null;

    @Basic(optional = false)
    @Column(name = "name")
    private String name = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;

        Dog dog = (Dog) o;

        if (id != null ? !id.equals(dog.id) : dog.id != null) return false;
        return !(name != null ? !name.equals(dog.name) : dog.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}