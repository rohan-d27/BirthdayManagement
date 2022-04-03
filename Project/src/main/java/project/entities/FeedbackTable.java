package project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the feedback_table database table.
 * 
 */
@Entity
@Table(name = "feedback_table")
//@NamedQuery(name="FeedbackTable.findAll", query="SELECT f FROM FeedbackTable f")
public class FeedbackTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "feedback_id")
	private int feedbackId;

	@Column(name = "feedback_details")
	private String feedbackDetails;

	@Column(name = "order_id")
	private int orderId;

	public FeedbackTable() {
	}

	public int getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackDetails() {
		return this.feedbackDetails;
	}

	public void setFeedbackDetails(String feedbackDetails) {
		this.feedbackDetails = feedbackDetails;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}