package mg.federation.agricole_api.dto;

public record MemberDescriptionDTO(
    String id,
    String firstName,
    String lastName,
    String email,
    String occupation
) {}