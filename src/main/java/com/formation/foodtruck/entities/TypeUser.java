package com.formation.foodtruck.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Type_user database table.
 * 
 */
@Entity
@Table(name="Type_user")
@NamedQuery(name="TypeUser.findAll", query="SELECT t FROM TypeUser t")
public class TypeUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Type_user_id")
	private int type_user_id;

	@Column(name="type")
	private String type;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="typeUser")
	private List<Users> users;

	public TypeUser() {
	}

	public int getType_user_id() {
		return this.type_user_id;
	}

	public void setType_user_id(int type_user_id) {
		this.type_user_id = type_user_id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Users> getUsers() {
		return this.users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Users addUser(Users user) {
		getUsers().add(user);
		user.setTypeUser(this);

		return user;
	}

	public Users removeUser(Users user) {
		getUsers().remove(user);
		user.setTypeUser(null);

		return user;
	}

}