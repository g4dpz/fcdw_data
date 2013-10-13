package uk.org.funcube.fcdw.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HexFrame")
public class HexFrameEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(cascade={CascadeType.MERGE})
	@JoinTable(name="HexFrameUser", 
			joinColumns=@JoinColumn(name="hexFrameId"),
			inverseJoinColumns=@JoinColumn(name="userId"))  
	private Set<UserEntity> users = new HashSet<UserEntity>();

	private Long satelliteId;
	private Long sequenceNumber;
	private String hexString;
	private Date createdDate;
	private boolean valid;
	private Long frameType;
	private boolean wodProcessed;
	private boolean fitterProcessed;
	private boolean highPrecisionProcessed;
	
	public HexFrameEntity() {
	}
	
	public HexFrameEntity(
			final Long satelliteId, final Long frameType, final Long sequenceNumber, 
			final String hexString, final Date createdDate, final boolean valid) {
		this.satelliteId = satelliteId;
		this.frameType = frameType;
		this.sequenceNumber = sequenceNumber;
		this.hexString = hexString;
		this.createdDate = createdDate;
		this.valid = valid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}

	public Long getSatelliteId() {
		return satelliteId;
	}

	public void setSatelliteId(Long satelliteId) {
		this.satelliteId = satelliteId;
	}

	public Long getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Long sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getHexString() {
		return hexString;
	}

	public void setHexString(String hexString) {
		this.hexString = hexString;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Long getFrameType() {
		return frameType;
	}

	public void setFrameType(Long frameType) {
		this.frameType = frameType;
	}

	public boolean isWodProcessed() {
		return wodProcessed;
	}

	public void setWodProcessed(boolean wodProcessed) {
		this.wodProcessed = wodProcessed;
	}

	public boolean isFitterProcessed() {
		return fitterProcessed;
	}

	public void setFitterProcessed(boolean fitterProcessed) {
		this.fitterProcessed = fitterProcessed;
	}

	public boolean isHighPrecisionProcessed() {
		return highPrecisionProcessed;
	}

	public void setHighPrecisionProcessed(boolean highPrecisionProcessed) {
		this.highPrecisionProcessed = highPrecisionProcessed;
	}

}
