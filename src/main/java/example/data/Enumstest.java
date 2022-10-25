package example.data;

import jakarta.persistence.*;

@Entity
@Table(name = "ENUMSTEST" )
public class Enumstest {
    private int id;
    private PhoneType type;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "TYPE", nullable = true, length = 255)
    @Enumerated(EnumType.STRING)
    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }


}
