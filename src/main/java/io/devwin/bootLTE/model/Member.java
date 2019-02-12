package io.devwin.bootLTE.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(of = "uid")
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length=50)
    private String uid;

    @Column(nullable = false, length=200)
    private String passwd;

    @Column(nullable = false, unique = true, length=50)
    private String email;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="uid")
    private List<MemberRole> roles;

}