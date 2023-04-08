package by.yanodincov.goat.budget.db.entity;

import by.yanodincov.goat.budget.db.type.annotation.GeneratedUUIDV7;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "operation", indexes = {
        @Index(name = "operation_user_category_uuid_idx", columnList = "user_uuid,category_uuid")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {
    @Id
    @GeneratedUUIDV7
    @Column(name = "operation_uuid", updatable = false, nullable = false, columnDefinition = "uuid not null")
    private UUID operationUUID;

    @Column(name = "user_uuid", updatable = false, nullable = false, columnDefinition = "uuid not null")
    private UUID userUUID;

    @ManyToOne(targetEntity = Category.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "category_uuid", updatable = false, nullable = false, columnDefinition = "uuid not null")
    private UUID categoryUUID;

    @Column(name = "amount", nullable = false)
    private Float amount;
}
