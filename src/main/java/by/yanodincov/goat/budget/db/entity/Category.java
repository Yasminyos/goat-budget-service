package by.yanodincov.goat.budget.db.entity;

import by.yanodincov.goat.budget.db.type.annotation.GeneratedUUIDV7;
import com.github.f4b6a3.uuid.util.UuidUtil;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "category", indexes = {
        @Index(name = "category_user_uuid_idx", columnList = "user_uuid")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedUUIDV7
    @Column(name = "category_uuid", updatable = false, nullable = false, columnDefinition = "uuid not null")
    private UUID categoryUUID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "user_uuid", updatable = false, nullable = false, columnDefinition = "uuid not null")
    private UUID userUUID;

    @Column(name = "is_income", updatable = true, nullable = false, columnDefinition = "boolean not null")
    private Boolean isIncome;

    public Instant getCreatedAt() {
        return UuidUtil.getInstant(this.categoryUUID);
    }
}
