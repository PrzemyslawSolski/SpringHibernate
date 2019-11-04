package pl.coderslab.article;

import pl.coderslab.author.Author;
import pl.coderslab.category.Category;
import pl.coderslab.validate.ArticleValidationGroup;
import pl.coderslab.validate.Categories;
import pl.coderslab.validate.DraftValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    @NotBlank(groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    @Size(max = 200, groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    private String title;

    @ManyToOne
    private Author author;

    //    @ManyToMany(mappedBy = "articles")
    @ManyToMany
    @JoinTable(name = "article_categories")
    @NotEmpty(groups = {ArticleValidationGroup.class})
    @Categories(value = 5, groups = {ArticleValidationGroup.class})
    private List<Category> categories;

    @NotBlank(groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    @Size(min = 5, groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    private String content;

    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean draft;


    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                "}\n";
    }
}
