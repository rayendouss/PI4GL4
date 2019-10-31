package tn.esprit.timesheet.managedbean;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import Entities.Role;
@ManagedBean(name = "data")
@ApplicationScoped
public class data implements Serializable{
	private static final long serialVersionUID = 1L;
	public Role[] getRoles() { return Role.values();
}}
