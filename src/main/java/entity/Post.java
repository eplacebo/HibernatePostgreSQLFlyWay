package entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "post")
@Entity
public class Post implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Basic
    @Column(name = "content", nullable = true, length = -1)
    private String content;

    @CreationTimestamp
    @Column(name = "created", nullable = true)
    private Timestamp created;

    @UpdateTimestamp
    @Column(name = "updated", nullable = true)
    private Timestamp updated;

    @Override
    public String toString() {
        return "Post: " + id + " | " + content + '\n' + "Created: " + created + " | " + "Updated: " + updated + "\n" + "-------------------------------------------------------------------" + "\n";
    }
}
