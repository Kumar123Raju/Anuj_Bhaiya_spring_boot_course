package com.example.ubberApp.ubberApp.Repository;

import com.example.ubberApp.ubberApp.Entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
