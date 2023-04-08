package by.yanodincov.goat.budget.handlers.model.request;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.hibernate.validator.constraints.UUID;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GetCategoryRequest {
    @UUID
    public java.util.UUID categoryUUID;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    public Date createdAfter;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    public Date createdBefore;

    @UUID
    public java.util.UUID lastUUID;
}
