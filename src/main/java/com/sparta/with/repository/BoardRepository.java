package com.sparta.with.repository;

import com.sparta.with.entity.Board;
import com.sparta.with.entity.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByAuthorOrderByCreatedAtDesc(User author);
}
