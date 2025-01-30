package com.HMSApp.Hospital.Management.System.doclogin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appointments")
public class appointments {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    private String name;
    private String age;
    private String symptoms;
	private String number;

    	public appointments(long id, String name, String age, String symptoms, String number) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.symptoms = symptoms;
		this.number = number;
	}
		@Override
	public String toString() {
		return "appointments [id=" + id + ", name=" + name + ", age=" + age + ", symptoms=" + symptoms + ", number="
				+ number + "]";
	}

      public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public appointments() {
		super();
		// TODO Auto-generated constructor stub
	}
}
