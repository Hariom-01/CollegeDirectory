package com.aryajohary.collegedirectory.schemas;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@OnDelete(action = OnDeleteAction.CASCADE)
@Getter @Setter @NoArgsConstructor
public class FacultyProfile extends User{

    @Size(max = 255)
    private String photo;

    @ManyToOne
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    @Size(max = 255)
    private String officeHours;

    public FacultyProfile(String username,
                          String password,
                          String name,
                          String email,
                          String phone,
                          String photo,
                          Department department,
                          String officeHours) {
        super(username, password, name, email, phone);
        this.setRole(Role.Faculty_Member);
        this.photo = photo;
        this.department = department;
        this.officeHours = officeHours;
    }

}
