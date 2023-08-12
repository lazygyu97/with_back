package com.sparta.with.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name = "users")
@EqualsAndHashCode(of="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String image;

    @Builder.Default
    @OneToMany(mappedBy = "collaborator", orphanRemoval = true)
    private List<BoardUser> boardUsers = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "collaborator", orphanRemoval = true)
    private List<CardUser> cardUsers = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "alarmTarget", orphanRemoval = true)
    private List<AlarmUser> alarmUsers = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "author", orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "author", orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;
}