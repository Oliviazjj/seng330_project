package org.springframework.samples.petclinic.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "events")
public class Event extends NamedEntity {

	 @NotEmpty
	 @Column(name = "amountOfPeople")
	 private int amountOfPeople;
	
	
	@Column(name = "event_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date eventDate;
	
	@NotEmpty
	@Column(name = "appetizer")
	private String appetizer;
	
	@NotEmpty
	@Column(name = "entree")
	private String entree;
	
	@NotEmpty
	@Column(name = "dessert")
	private String dessert;

    @NotEmpty
    @Column(name = "description")
    private String description;
   
    
   

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    

    public int getAmountOfPeople() {
		return amountOfPeople;
	}

	public void setAmountOfPeople(int amountOfPeople) {
		this.amountOfPeople = amountOfPeople;
	}

	public String getAppetizer() {
		return appetizer;
	}

	public void setAppetizer(String appetizer) {
		this.appetizer = appetizer;
	}

	public String getEntree() {
		return entree;
	}

	public void setEntree(String entree) {
		this.entree = entree;
	}

	public String getDessert() {
		return dessert;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
        return this.user;
    }

    protected void setUser(User user) {
        this.user = user;
    }


}