package sample.practise.relationship.onetomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class Cart {
	
	@OneToMany(mappedBy="cart")  //inverse side
	//@JoinColumn(name="cart_id")  //owning side
	private List<Item> items;

}


