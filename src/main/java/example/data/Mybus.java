package example.data;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Mybus {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @OneToMany(mappedBy = "mybusByBusid")
    private Collection<Entitybusversion> entitybusversionsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mybus mybus = (Mybus) o;

        if (id != mybus.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public Collection<Entitybusversion> getEntitybusversionsById() {
        return entitybusversionsById;
    }

    public void setEntitybusversionsById(Collection<Entitybusversion> entitybusversionsById) {
        this.entitybusversionsById = entitybusversionsById;
    }
}
