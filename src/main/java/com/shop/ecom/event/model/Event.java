package com.shop.ecom.event.model;

import java.time.LocalDateTime;
import java.util.List;

import com.shop.ecom.user.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime eventDate;

    @ManyToOne
    private User organizer;

    @OneToMany(mappedBy = "event")
    private List<EventRegistration> registrations;
}
