package org.springframework.samples.petclinic.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "events")
public class Event extends NamedEntity {

	 @NotNull
	 @Column(name = "amountOfPeople")
	 private int amountOfPeople;
	
	
	@Column(name = "event_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date eventDate;
	
	@NotEmpty
	@Column(name = "location")
	private String location;
	
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

    public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
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

    public void setUser(User user) {
        this.user = user;
    }


}
