package entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "region")
@Entity
public class Region implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;

    @Override
    public String toString() {
        return "Region: " + id + " | " + name;
    }
}
