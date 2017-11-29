package org.springframework.samples.petclinic.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "username")
    @NotEmpty
    private String username;

    @Column(name = "password")
    @NotEmpty
    private String password;
    
    @Column(name = "email")
    @NotEmpty
    private String email;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Event> events;


    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    protected Set<Event> getEventsInternal() {
        if (this.events == null) {
            this.events = new HashSet<>();
        }
        return this.events;
    }

    protected void setEventsInternal(Set<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        List<Event> sortedEvents = new ArrayList<>(getEventsInternal());
        PropertyComparator.sort(sortedEvents, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedEvents);
    }

    public void addEvent(Event event) {
        getEventsInternal().add(event);
        event.setUser(this);
    }

    /**
     * Return the Event with the given name, or null if none found for this User.
     *
     * @param name to test
     * @return true if event name is already in use
     */
    public Event getEvent(String name) {
        return getEvent(name, false);
    }

    /**
     * Return the Event with the given name, or null if none found for this User.
     *
     * @param name to test
     * @return true if event name is already in use
     */
    public Event getEvent(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Event event : getEventsInternal()) {
            if (!ignoreNew || !event.isNew()) {
                String compName = event.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return event;
                }
            }
        }
        return null;
    }
}
