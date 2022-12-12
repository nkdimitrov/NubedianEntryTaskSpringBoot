package nubedianEntryTask.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "socketlist")
public class SocketItem {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 @Column(name = "socket")
	 private String socket;

	 public SocketItem() {};
  
	 public SocketItem(Integer id, String socket) {
		 this.id = id;
		 this.socket = socket;
	 }

	 public Integer getId() {
		 return id;
	 }

	 public void setId(Integer id) {
		 this.id = id;
	 }

	 public String getSocket() {
		 return socket;
	 }

	 public void setSocket(String socket) {
		 this.socket = socket;
	 }
	
}
