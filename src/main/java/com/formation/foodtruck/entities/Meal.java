package com.formation.foodtruck.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the Meal database table.
 * 
 */
@Entity
@NamedQuery(name="Meal.findAll", query="SELECT m FROM Meal m")
public class Meal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="meal_id")
	private Integer mealId;

	private Time end;

	private Time start;

	private String type;

	//bi-directional many-to-many association to Family
	@JsonIgnore
	@ManyToMany(mappedBy="meals")
	private List<Family> families;

	public Meal() {
	}

	public int getMealId() {
		return this.mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public Time getEnd() {
		return this.end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}

	public Time getStart() {
		return this.start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Family> getFamilies() {
		return this.families;
	}

	public void setFamilies(List<Family> families) {
		this.families = families;
	}

}