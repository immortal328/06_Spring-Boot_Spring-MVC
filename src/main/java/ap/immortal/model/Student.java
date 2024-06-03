package ap.immortal.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String firstName;
	 
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private String operatingSystem;

}
