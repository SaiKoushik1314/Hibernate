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
@Table(name = "APP.SPEAKER")
public class Speaker {
	private int speakerId;
	private String speakerName;

	public Speaker() {
	}

	public Speaker(String speakerName) {
		this.speakerName = speakerName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "SPEAKER_ID")
	public int getSpeakerId() {
		return speakerId;
	}

	public void setSpeakerId(int speakerId) {
		this.speakerId = speakerId;
	}

	@Column(name = "SPEAKER_NAME")
	public String getSpeakerName() {
		return speakerName;
	}

	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}

	private Set<Event> events;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "APP.EVENT_SPEAKER", joinColumns = { @JoinColumn(name = "SPEAKER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "EVENT_ID") })
	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

}
