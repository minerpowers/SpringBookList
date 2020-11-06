package dmacc.beans;

import javax.persistence.Embeddable;

import lombok.Data;


@Embeddable
@Data
public class Author {
	private String firstName;
	private String lastName;
}
