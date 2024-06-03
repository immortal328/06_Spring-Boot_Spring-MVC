package ap.immortal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {	
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;

}
