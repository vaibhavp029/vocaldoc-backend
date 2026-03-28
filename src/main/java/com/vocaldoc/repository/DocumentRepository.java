package com.vocaldoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vocaldoc.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
