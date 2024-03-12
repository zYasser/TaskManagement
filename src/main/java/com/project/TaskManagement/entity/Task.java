package com.project.TaskManagement.entity;


import com.project.TaskManagement.validation.PresentOrFuture;
import com.project.TaskManagement.validation.ValidateTaskTitle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity(name = "tasks")
public class Task {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "created_at")

    private final LocalDateTime createdAt=LocalDateTime.now();;
    @PresentOrFuture
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)

    private LocalDateTime deadline;
    @Column(name = "updated_at")

    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING) // Specify how the enum should be persisted
    private Priority priority;

    @Column(name = "is_completed")
    private boolean isCompleted=false;
    @NotBlank
    @ValidateTaskTitle
    @Size(min = 3 ,max = 300)
    private String title;
    private String content;


    public Task(long id, LocalDateTime fakeCreatedAt, LocalDateTime deadline, LocalDateTime updatedAt, Priority priority, boolean isCompleted, String title,
            String content) {
        this.id = id;
        this.deadline = deadline;
        this.updatedAt = updatedAt;
        this.priority = priority;
        this.isCompleted = isCompleted;
        this.title = title;
        this.content = content;
    }


    public Task() {
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public LocalDateTime getDeadline() {
        return deadline;
    }


    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }


    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    public Priority getPriority() {
        return priority;
    }


    public void setPriority(Priority priority) {
        this.priority = priority;
    }


    public boolean isCompleted() {
        return isCompleted;
    }


    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", createdAt=" + createdAt + ", deadline=" + deadline + ", updatedAt=" + updatedAt + ", priority=" + priority + ", isCompleted=" + isCompleted + ", title='" + title + '\'' + ", content='" + content + '\'' + '}';
    }

}
