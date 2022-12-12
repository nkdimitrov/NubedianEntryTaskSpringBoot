package nubedianEntryTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nubedianEntryTask.model.CpuItem;

@Repository
public interface CpuItemRepository extends JpaRepository<CpuItem, Integer> {
}
