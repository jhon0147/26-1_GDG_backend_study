package com.example.shop.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_loginId", length = 50)
    private String loginId;

    @Column(name = "member_pw", length = 100)
    private String password;

    @Column(name = "member_phone", length = 20)
    private String phoneNumber;

    @Column(name = "member_address", length = 255)
    private String address;

    @Column(name = "member_point")
    private int point;

    public Member(String loginId, String password, String phoneNumber, String address) {
        this.loginId = loginId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.point = 0;
    }

    //회원저보 수정
    public void updateInfo(String password, String phoneNumber, String address) {
        //유효성 처리 관점에서 대체될 코드임
        if (password != null){
            this.password = password;
        }
        if(phoneNumber != null){
            this.phoneNumber = phoneNumber;
        }
        if(address != null){
            this.address = address;
        }
    }

}
