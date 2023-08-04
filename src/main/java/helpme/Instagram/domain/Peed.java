package helpme.Instagram.Domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Peed {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "CONTENT")
    private String content;

    @OneToMany(mappedBy = "peed")
    private List<Comment> comments = new ArrayList<>();

    @OneToOne
    private Heart heart;
}
