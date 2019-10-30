package pl.coderslab.article;

import pl.coderslab.author.Author;
import pl.coderslab.category.Category;

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
    @Column(length=200)
    @NotBlank
    @Size(max=200)
    private String title; // (max. 200 znaków),
    @ManyToOne
    private Author author; // - (powiązanie relacją do klasy Author) - artykuł może mieć tylko jednego autora
//    @ManyToMany(mappedBy = "articles")
    @ManyToMany
    @JoinTable(name = "article_categories")
    @NotEmpty
    private List<Category> categories; // - (powiązanie relacją do klasy Category) - artykuł może należeć do wielu kategorii
    @NotBlank
    @Size(min=500)
    private String content;
    private LocalDateTime created; // (wartość ma być automatycznie dodawana podczas zapisu)
    private LocalDateTime updated; // (wartość ma być automatycznie zmieniana podczas edycji).


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
