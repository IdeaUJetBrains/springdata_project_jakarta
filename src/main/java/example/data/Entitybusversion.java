package example.data;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "ENTITYBUSVERSION", schema = "PUBLIC", catalog = "PUBLIC")
public class Entitybusversion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "EID", nullable = false)
    private int eid;
    @Basic
    @Version
    @Column(name = "VERSION", nullable = true)
    private Integer version;
    @Basic
    @NaturalId
    @Column(name = "NATID", nullable = true, length = 255)
    private String natid;
    @Basic
    @Column(name = "BUSID", nullable = true, insertable = false, updatable = true)
    private Integer busid;


    @ManyToOne
    @JoinColumn(name = "BUSID", referencedColumnName = "ID", updatable = false, insertable = false )
    private Mybus mybusByBusid;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getNatid() {
        return natid;
    }

    public void setNatid(String natid) {
        this.natid = natid;
    }

    public Integer getBusid() {
        return busid;
    }

    public void setBusid(Integer busid) {
        this.busid = busid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entitybusversion that = (Entitybusversion) o;

        if (eid != that.eid) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (natid != null ? !natid.equals(that.natid) : that.natid != null) return false;
        if (busid != null ? !busid.equals(that.busid) : that.busid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eid;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (natid != null ? natid.hashCode() : 0);
        result = 31 * result + (busid != null ? busid.hashCode() : 0);
        return result;
    }

    public Mybus getMybusByBusid() {
        return mybusByBusid;
    }

    public void setMybusByBusid(Mybus mybusByBusid) {
        this.mybusByBusid = mybusByBusid;
    }
}
