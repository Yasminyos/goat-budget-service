package by.yanodincov.goat.budget.db.repository.jpa;

import by.yanodincov.goat.budget.db.entity.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperationRepository  extends CrudRepository<Operation, UUID> {
}
