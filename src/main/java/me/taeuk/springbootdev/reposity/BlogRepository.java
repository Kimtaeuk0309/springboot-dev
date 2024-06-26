package me.taeuk.springbootdev.reposity;

import me.taeuk.springbootdev.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
