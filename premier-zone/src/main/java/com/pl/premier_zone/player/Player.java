package com.pl.premier_zone.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_stats")
public class Player {
@Id
@Column(name = "player_name",unique = true)
private String name;
private String nation;
private String pos;
private Integer age;
private Integer mp;
private Integer starts;
private Double min;
private Double goals;
private Double assists;
private Double penalties;
private Double yellowcards;
private Double redcards;
private Double expectedGoals;
private Double expectedAssists;
private String teamName;



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getNation() {
	return nation;
}



public void setNation(String nation) {
	this.nation = nation;
}



public String getPos() {
	return pos;
}



public void setPos(String pos) {
	this.pos = pos;
}



public Integer getAge() {
	return age;
}



public void setAge(Integer age) {
	this.age = age;
}



public Integer getMp() {
	return mp;
}



public void setMp(Integer mp) {
	this.mp = mp;
}



public Integer getStarts() {
	return starts;
}



public void setStarts(Integer starts) {
	this.starts = starts;
}



public Double getMin() {
	return min;
}



public void setMin(Double min) {
	this.min = min;
}



public Double getGoals() {
	return goals;
}



public void setGoals(Double goals) {
	this.goals = goals;
}



public Double getAssists() {
	return assists;
}



public void setAssists(Double assists) {
	this.assists = assists;
}



public Double getPenalties() {
	return penalties;
}



public void setPenalties(Double penalties) {
	this.penalties = penalties;
}



public Double getYellowcards() {
	return yellowcards;
}



public void setYellowcards(Double yellowcards) {
	this.yellowcards = yellowcards;
}



public Double getRedcards() {
	return redcards;
}



public void setRedcards(Double redcards) {
	this.redcards = redcards;
}



public Double getExpectedGoals() {
	return expectedGoals;
}



public void setExpectedGoals(Double expectedGoals) {
	this.expectedGoals = expectedGoals;
}



public Double getExpectedAssists() {
	return expectedAssists;
}



public void setExpectedAssists(Double expectedAssists) {
	this.expectedAssists = expectedAssists;
}



public String getTeamName() {
	return teamName;
}



public void setTeamName(String teamName) {
	this.teamName = teamName;
}



public Player(String name, String nation, String pos, Integer age, Integer mp, Integer starts, Double min, Double goals,
		Double assists, Double penalties, Double yellowcards, Double redcards, Double expectedGoals,
		Double expectedAssists, String teamName) {
	super();
	this.name = name;
	this.nation = nation;
	this.pos = pos;
	this.age = age;
	this.mp = mp;
	this.starts = starts;
	this.min = min;
	this.goals = goals;
	this.assists = assists;
	this.penalties = penalties;
	this.yellowcards = yellowcards;
	this.redcards = redcards;
	this.expectedGoals = expectedGoals;
	this.expectedAssists = expectedAssists;
	this.teamName = teamName;
}



public Player() {
}



}
