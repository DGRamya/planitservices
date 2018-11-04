//package com.planit.entity;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//@Entity
//public class EventDetails {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int eventid;
//	
//	@Id
//	@OneToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="groupid")
//	private int gid;
//	
//	private String eventname;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date eventdate;
//	
//	private String venue;
//	private String invitationMessage;
//	
//	@ElementCollection
//	private List<String> invitationList;
//	
//	@ElementCollection
//	private List<String> shoppingList;
//	
//	@ElementCollection
//	private List<String> todoList;
//}
