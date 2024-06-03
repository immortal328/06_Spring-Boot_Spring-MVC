package ap.immortal.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
	
	@Min(value=1, message="must be greater than or equal to 1")
    @Max(value=10, message="must be less than or equal to 10")
    private int std;
	 
	private String country;
	private String favoriteLanguage;
	private String operatingSystem;

}
