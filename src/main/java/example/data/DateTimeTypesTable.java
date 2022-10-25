package example.data;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "DATE_TIME_TYPES_TABLE", schema = "PUBLIC", catalog = "PUBLIC")
public class DateTimeTypesTable {
    private int id;
    private Time vTime;
    private Time vTimeWithoutTimeZone;
    private Time vTimeWithTimeZone;
    private Date vDate;
    private Timestamp vTimestampWithTimeZone;
    private Timestamp vTimestampWithoutTimeZone;
    private Timestamp vTimestamp;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "V_TIME", nullable = true)
    public Time getvTime() {
        return vTime;
    }

    public void setvTime(Time vTime) {
        this.vTime = vTime;
    }

    @Basic
    @Column(name = "V_TIME_WITHOUT_TIME_ZONE", nullable = true)
    public Time getvTimeWithoutTimeZone() {
        return vTimeWithoutTimeZone;
    }

    public void setvTimeWithoutTimeZone(Time vTimeWithoutTimeZone) {
        this.vTimeWithoutTimeZone = vTimeWithoutTimeZone;
    }

    @Basic
    @Column(name = "V_TIME_WITH_TIME_ZONE", nullable = true)
    public Time getvTimeWithTimeZone() {
        return vTimeWithTimeZone;
    }

    public void setvTimeWithTimeZone(Time vTimeWithTimeZone) {
        this.vTimeWithTimeZone = vTimeWithTimeZone;
    }

    @Basic
    @Column(name = "V_DATE", nullable = true)
    public Date getvDate() {
        return vDate;
    }

    public void setvDate(Date vDate) {
        this.vDate = vDate;
    }

    @Basic
    @Column(name = "V_TIMESTAMP_WITH_TIME_ZONE", nullable = true)
    public Timestamp getvTimestampWithTimeZone() {
        return vTimestampWithTimeZone;
    }

    public void setvTimestampWithTimeZone(Timestamp vTimestampWithTimeZone) {
        this.vTimestampWithTimeZone = vTimestampWithTimeZone;
    }

    @Basic
    @Column(name = "V_TIMESTAMP_WITHOUT_TIME_ZONE", nullable = true)
    public Timestamp getvTimestampWithoutTimeZone() {
        return vTimestampWithoutTimeZone;
    }

    public void setvTimestampWithoutTimeZone(Timestamp vTimestampWithoutTimeZone) {
        this.vTimestampWithoutTimeZone = vTimestampWithoutTimeZone;
    }

    @Basic
    @Column(name = "V_TIMESTAMP", nullable = true)
    public Timestamp getvTimestamp() {
        return vTimestamp;
    }

    public void setvTimestamp(Timestamp vTimestamp) {
        this.vTimestamp = vTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DateTimeTypesTable that = (DateTimeTypesTable) o;

        if (id != that.id) return false;
        if (vTime != null ? !vTime.equals(that.vTime) : that.vTime != null) return false;
        if (vTimeWithoutTimeZone != null ? !vTimeWithoutTimeZone.equals(that.vTimeWithoutTimeZone) : that.vTimeWithoutTimeZone != null)
            return false;
        if (vTimeWithTimeZone != null ? !vTimeWithTimeZone.equals(that.vTimeWithTimeZone) : that.vTimeWithTimeZone != null)
            return false;
        if (vDate != null ? !vDate.equals(that.vDate) : that.vDate != null) return false;
        if (vTimestampWithTimeZone != null ? !vTimestampWithTimeZone.equals(that.vTimestampWithTimeZone) : that.vTimestampWithTimeZone != null)
            return false;
        if (vTimestampWithoutTimeZone != null ? !vTimestampWithoutTimeZone.equals(that.vTimestampWithoutTimeZone) : that.vTimestampWithoutTimeZone != null)
            return false;
        if (vTimestamp != null ? !vTimestamp.equals(that.vTimestamp) : that.vTimestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (vTime != null ? vTime.hashCode() : 0);
        result = 31 * result + (vTimeWithoutTimeZone != null ? vTimeWithoutTimeZone.hashCode() : 0);
        result = 31 * result + (vTimeWithTimeZone != null ? vTimeWithTimeZone.hashCode() : 0);
        result = 31 * result + (vDate != null ? vDate.hashCode() : 0);
        result = 31 * result + (vTimestampWithTimeZone != null ? vTimestampWithTimeZone.hashCode() : 0);
        result = 31 * result + (vTimestampWithoutTimeZone != null ? vTimestampWithoutTimeZone.hashCode() : 0);
        result = 31 * result + (vTimestamp != null ? vTimestamp.hashCode() : 0);
        return result;
    }
}
