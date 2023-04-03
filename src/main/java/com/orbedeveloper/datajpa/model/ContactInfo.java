package com.orbedeveloper.datajpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact_info")
public class ContactInfo {
    /*@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_info_generator")
    @SequenceGenerator(name = "contact_info_generator")
    private Long id;*/

    @Id
    @Column(name = "student_id")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zip", nullable = false)
    private String zip;

   /* @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "student_id")
    Student student;*/

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @MapsId
    @JoinColumn(name = "student_id")
    private Student student;

    @Override
    public String toString() {
        return "ContactInfo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
