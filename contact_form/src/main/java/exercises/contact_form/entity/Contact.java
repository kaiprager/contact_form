package exercises.contact_form.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "contact_form")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please enter your name!")
    @Size(min = 1, message = "Please enter your name!")
    private String name;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Please enter your email!")
    @Size(min = 1, message = "Please enter your email!")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Please enter a valid email!")
    private String email;

    @NotNull(message = "Subject is required!")
    @Size(min =  1, message = "Subject is required!")
    private String subject;

    @NotNull(message = "Message is required!")
    @Size(min = 10, message = "Message must be at least 10 characters long!")
    private String message;

    private Boolean agreeTerms;


    // Constructors
    public Contact() {

    }

    public Contact(String name, String email, String subject, String message, Boolean agreeTerms) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.agreeTerms = agreeTerms;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getAgreeTerms() {
        return agreeTerms;
    }

    public void setAgreeTerms(Boolean agreeTerms) {
        this.agreeTerms = agreeTerms;
    }
}
