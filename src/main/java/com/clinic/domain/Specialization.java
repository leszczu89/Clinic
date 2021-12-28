package com.clinic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "SPECIALIZATIONS")
public class Specialization {
    @Id
    @NotNull
    @Column(name = "ID")
    public Long id;

    @NotNull
    @Column(name = "NAME")
    public String name;

    @Column(name = "ACTIVE")
    public Boolean active = true;

    public Specialization(Long id, String name) {
        this.id = id;
        this.name = name;
        this.active = true;
    }

    public Specialization() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialization that = (Specialization) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        return Objects.equals(active, that.active);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
