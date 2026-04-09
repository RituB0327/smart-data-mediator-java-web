package com.smartmediator.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="query_history")

public class QueryHistory {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;

private String queryText;

private String operation;

private String result;

private LocalDateTime createdAt;


public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getQueryText() {
return queryText;
}

public void setQueryText(String queryText) {
this.queryText = queryText;
}

public String getOperation() {
return operation;
}

public void setOperation(String operation) {
this.operation = operation;
}

public String getResult() {
return result;
}

public void setResult(String result) {
this.result = result;
}

public LocalDateTime getCreatedAt() {
return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
this.createdAt = createdAt;
}

}