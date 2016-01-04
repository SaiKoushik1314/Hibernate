package com.training;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APP.EVENT")
public class Event {
	private int eventId;
	private String eventName;

	public Event() {
	}

	public Event(String eventName) {
		this.eventName = eventName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "EVENT_ID")
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Column(name = "EVENT_NAME")
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	private Set<Speaker> speakers;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "APP.EVENT_SPEAKER", joinColumns = { @JoinColumn(name = "EVENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "SPEAKER_ID") })
	public Set<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Set<Speaker> speakers) {
		this.speakers = speakers;
	}

}
