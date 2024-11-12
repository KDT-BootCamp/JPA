package jpa.com.jpa_pjt.jpa.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.Data;

//@Table(name="TB_JPA_SAMPLE") 
@Entity(name="TB_JPA_SAMPLE") 
@Data
public class SampleEntity {

    @Id // pk
    @Column(name = "seq") // 속성 이름 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 설정
    private Integer seq;
    @Column(name = "id")
    private String id;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "name")
    private String name;

    
}
