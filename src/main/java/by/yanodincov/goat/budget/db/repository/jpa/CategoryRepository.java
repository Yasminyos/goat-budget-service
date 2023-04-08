package by.yanodincov.goat.budget.db.repository.jpa;

import by.yanodincov.goat.budget.db.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends CrudRepository<Category, UUID> {
    @Query("select c from Category c where c.user_uuid = :user_uuid")
    List<Category> getByUserUuid(@Param("user_uuid") @NonNull UUID user_uuid);
}
