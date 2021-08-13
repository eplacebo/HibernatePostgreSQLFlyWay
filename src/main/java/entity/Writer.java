package entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "writer")
@RequiredArgsConstructor
@Entity
public class Writer implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Basic
    @Column(name = "firstname", nullable = true, length = -1)
    private String firstname;

    @NonNull
    @Basic
    @Column(name = "lastname", nullable = true, length = -1)
    private String lastname;

    @NonNull
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_writer")
    private List<Post> posts = new ArrayList<>();

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id_region", referencedColumnName = "id")
    private Region region;

    @Override
    public String toString() {
        return "Writer: " + id + " | " + firstname + " " + lastname + '\n' +
                region + '\n' +
                posts;
    }
}


