package org.example.demo.model;

import jakarta.persistence.*;

@Entity

@DiscriminatorValue("ADMIN")
public class Admin extends User {
    // Admin-spesifikke funksjoner kan implementeres her senere
}

