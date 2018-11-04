//package com.planit.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class GroupDetails {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int groupid;
//	
//	@Id
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="userid")
//	private int uid;
//}
