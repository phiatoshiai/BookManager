package vn.codegym.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.bookmanager.entity.Storage;

@Repository
public interface StorageRepository extends JpaRepository<Storage,Long> {
}
