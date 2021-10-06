package sample.practise.relationship.onetomany;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ITEM")
public class Item {
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name="cart_id",nullable=false)  //owning side
	//@JoinColumn(name="cart_id",insertable=false,updatable=false) //inverse side
	private Cart cart;

}
