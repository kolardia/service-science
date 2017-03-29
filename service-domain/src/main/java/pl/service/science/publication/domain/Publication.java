package pl.service.science.publication.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.service.science.authorization.domain.Authorization;
import pl.service.science.authorization.domain.User;
import pl.service.science.localization.domain.Location;
import pl.service.science.translation.domain.Translation;

/**
 * Mapping a publication class in a database named table:  "publication"
 * 
 * @author Monika Senderecka
 *
 */
@Entity
@Table(name = "publication")
public class Publication {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "publication_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "publication_id")
	public Long id;
	
	/**
	 * The mapping on a database for column name: "title_translation_id"; the mapping on a database is one-to-one
	 */
	@OneToOne
	@JoinColumn(name = "title_translation_id")
	public Translation title;
	
	/**
	 * The mapping on a database for column name: "publication_enabled"
	 */
	@Column(name = "publication_enabled")
	public Boolean enabled;
	
	/**
	 * The mapping on a database for column name: "publication_type_id"
	 */
	
	@Column(name = "publication_type_id")
	public String type;

	/**
	 * The mapping on a database for column name: "publication_state_id"; the mapping on a database is many-to-one
	 */
	@ManyToOne
	@JoinColumn(name = "publication_state_id")
	public State state;

	/**
	 * The mapping on a database for column name: "contents_translation_id"; the mapping on a database is one-to-one
	 */
	@OneToOne
	@JoinColumn(name = "contents_translation_id")
	public Translation contents;

	/**
	 * The mapping on a database for column name: "category_id"
	 */
	@Column(name = "category_id")
	public String category;
	
	/**
	 * The mapping on a database for column name: "autorization_id"; the mapping on a database is one-to-one
	 */
	@ManyToOne
	@JoinColumn(name = "autorization_id")
	public Authorization autorization;
	
	/**
	 * The mapping on a database for column name: "candidate_profile_id"; the mapping on a database is one-to-one
	 */
	@OneToOne
	@JoinColumn(name = "candidate_profile_id")
	public Translation candidateProfile;
	
	/**
	 * The mapping on a database for column name: "purpose_of_event_id"; the mapping on a database is one-to-one
	 */
	@OneToOne
	@JoinColumn(name = "purpose_of_event_id")
	public Translation purposeOfEvent;
	
	/**
	 * The mapping on a database for column name: "event_program_id"; the mapping on a database is one-to-one
	 */
	@OneToOne
	@JoinColumn(name = "event_program_id")
	public Translation eventProgram;
	
	/**
	 * The mapping on a database for column name: "methodology_id"; the mapping on a database is one-to-one
	 */
	@OneToOne
	@JoinColumn(name = "methodology_id")
	public Translation methodology;
	
	/**
	 * The mapping on a database for column name: "initial_requirements_id"; the mapping on a database is one-to-one
	 */
	@OneToOne
	@JoinColumn(name = "initial_requirements_id")
	public Translation initialRequirements;
	
	/**
	 * The mapping on a database for column name: "price"
	 */
	@Column(name = "price")
	public float price;

	/**
	 * The mapping on a database for column name: "number_of_seats"
	 */
	@Column(name = "number_of_seats")
	public int numberOfSeats;
	
	/**
	 * The mapping on a database for column name: "event_location_id"; the mapping on a database is many-to-one
	 */
	@ManyToOne
	@JoinColumn(name = "event_location_id")
	public Location eventLocation;
	
	/**
	 * The mapping on a database for column name: "leader_id"; the mapping on a database is many-to-one
	 */
	@ManyToOne
	@JoinColumn(name = "leader_id")
	public User leader;
	
	/**
	 * The mapping on a database for column name: "for_free"
	 */
	@Column(name = "for_free")
	public Boolean forFree;
	
	/**
	 * The mapping on a database for column name: "beginning_of_records"
	 */
	@Column(name = "beginning_of_records")
	public Date beginningOfRecords;
	
	/**
	 * The mapping on a database for column name: "end_of_records"
	 */
	@Column(name = "end_of_records")
	public Date endOfRecords;
	
	/**
	 * The mapping on a database for column name: "beginning_of_event"
	 */
	@Column(name = "beginning_of_event")
	public Date beginningOfevent;
	
	/**
	 * The mapping on a database for column name: "end_of_event"
	 */
	@Column(name = "end_of_event")
	public Date endOfevent;

	public Publication() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Translation getTitle() {
		return title;
	}

	public void setTitle(Translation title) {
		this.title = title;
	}

	public Translation getContents() {
		return contents;
	}

	public void setContents(Translation contents) {
		this.contents = contents;
	}

	public Authorization getAutorization() {
		return autorization;
	}

	public void setAutorization(Authorization autorization) {
		this.autorization = autorization;
	}

	public Translation getCandidateProfile() {
		return candidateProfile;
	}

	public void setCandidateProfile(Translation candidateProfile) {
		this.candidateProfile = candidateProfile;
	}

	public Translation getPurposeOfEvent() {
		return purposeOfEvent;
	}

	public void setPurposeOfEvent(Translation purposeOfEvent) {
		this.purposeOfEvent = purposeOfEvent;
	}

	public Translation getEventProgram() {
		return eventProgram;
	}

	public void setEventProgram(Translation eventProgram) {
		this.eventProgram = eventProgram;
	}

	public Translation getMethodology() {
		return methodology;
	}

	public void setMethodology(Translation methodology) {
		this.methodology = methodology;
	}

	public Translation getInitialRequirements() {
		return initialRequirements;
	}

	public void setInitialRequirements(Translation initialRequirements) {
		this.initialRequirements = initialRequirements;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Location getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(Location eventLocation) {
		this.eventLocation = eventLocation;
	}

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	public Boolean getForFree() {
		return forFree;
	}

	public void setForFree(Boolean forFree) {
		this.forFree = forFree;
	}
	
	
/*
	public Date getBeginningOfRecords() {
		return beginningOfRecords;
	}

	public void setBeginningOfRecords(Date beginningOfRecords) {
		this.beginningOfRecords = beginningOfRecords;
	}

	public Date getEndOfRecords() {
		return endOfRecords;
	}

	public void setEndOfRecords(Date endOfRecords) {
		this.endOfRecords = endOfRecords;
	}

	public Date getBeginningOfevent() {
		return beginningOfevent;
	}

	public void setBeginningOfevent(Date beginningOfevent) {
		this.beginningOfevent = beginningOfevent;
	}

	public Date getEndOfevent() {
		return endOfevent;
	}

	public void setEndOfevent(Date endOfevent) {
		this.endOfevent = endOfevent;
	}*/

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Publication [id=" + id + ", title=" + title + ", contents=" + contents + ", category=" + category + "]";
	}

}