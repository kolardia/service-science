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

@Entity
@Table(name = "publication")
public class Publication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "publication_id")
	public Long id;
	
	@OneToOne
	@JoinColumn(name = "title_translation_id")
	public Translation title;
	
	@Column(name = "publication_enabled")
	public Boolean enabled;
	
	@ManyToOne
	@JoinColumn(name = "publication_type_id")
	public Type type;

	@ManyToOne
	@JoinColumn(name = "publication_state_id")
	public State state;

	@OneToOne
	@JoinColumn(name = "contents_translation_id")
	public Translation contents;

	@ManyToOne
	@JoinColumn(name = "category_id")
	public Category category;
	
	@OneToOne
	@JoinColumn(name = "autorization_id")
	public Authorization autorization;
	
	@OneToOne
	@JoinColumn(name = "candidate_profile_id")
	public Translation candidateProfile;
	
	@OneToOne
	@JoinColumn(name = "purpose_of_event_id")
	public Translation purposeOfEvent;
	
	@OneToOne
	@JoinColumn(name = "event_program_id")
	public Translation eventProgram;
	
	@OneToOne
	@JoinColumn(name = "methodology_id")
	public Translation methodology;
	
	@OneToOne
	@JoinColumn(name = "initial_requirements_id")
	public Translation initialRequirements;
	
	@Column(name = "price")
	public float price;

	@Column(name = "number_of_seats")
	public int numberOfSeats;
	
	@ManyToOne
	@JoinColumn(name = "event_location_id")
	public Location eventLocation;
	
	@ManyToOne
	@JoinColumn(name = "leader_id")
	public User leader;
	
	@Column(name = "for_free")
	public Boolean forFree;
	
	@Column(name = "beginning_of_records")
	public Date beginningOfRecords;
	
	@Column(name = "end_of_records")
	public Date endOfRecords;
	
	@Column(name = "beginning_of_event")
	public Date beginningOfevent;
	
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
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
	}

	@Override
	public String toString() {
		return "Publication [id=" + id + ", title=" + title + ", contents=" + contents + ", category=" + category + "]";
	}

}