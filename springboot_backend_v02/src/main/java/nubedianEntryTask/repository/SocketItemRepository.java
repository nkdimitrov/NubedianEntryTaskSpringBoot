package nubedianEntryTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nubedianEntryTask.model.SocketItem;

@Repository
public interface SocketItemRepository extends JpaRepository<SocketItem, Integer> {

}
