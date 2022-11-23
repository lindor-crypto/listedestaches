package com.diallo.rest.webservices.restfullservices.Taches.Model;


import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
//@Table
public class Todo {

    	@Id
    	@GeneratedValue
    	@Column
	    private Long id;

    	@Column
	    private String description;

    	@Column
	    private Date targetDate;
    	@Column
	    private boolean isfinish;
    	
    	 @ManyToOne(cascade = CascadeType.ALL ) 
    	 @JoinColumn(name="idUser", nullable=false)
    	    private Users user;

		public Long getId() {
			return id;
		}
		protected Todo() {}

		public Todo(Long id, String description, Date targetDate, boolean isfinish) {
			super();
			this.id = id;
	
			this.description = description;
			this.targetDate = targetDate;
			this.isfinish = isfinish;
		}

		public void setId(Long id) {
			this.id = id;
		}


		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getTargetDate() {
			return targetDate;
		}

		public void setTargetDate(Date targetDate) {
			this.targetDate = targetDate;
		}

		public boolean isIsfinish() {
			return isfinish;
		}

		public void setIsfinish(boolean isfinish) {
			this.isfinish = isfinish;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Todo other = (Todo) obj;
			return Objects.equals(id, other.id);
		}

		@Override
		public String toString() {
			return "Todo [id=" + id + ", description=" + description + ", targetDate=" + targetDate + ", isfinish="
					+ isfinish + "]";
		}

} 
