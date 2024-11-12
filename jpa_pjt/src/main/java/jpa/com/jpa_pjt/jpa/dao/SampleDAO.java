package jpa.com.jpa_pjt.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jpa.com.jpa_pjt.jpa.domain.entity.SampleEntity;

// @Controller, @Service, @Mapper, @Repository

@Repository
//테이블 지정, pk 타입 지정
public interface SampleDAO extends JpaRepository<SampleEntity, Integer>{ 
    
    // 이러면 crud 기능 다 가능
    // 사용자 정의 메서드 추가 가능
    @Modifying
    @Transactional
    @Query("UPDATE TB_JPA_SAMPLE U " 
          +"SET U.id = :id, U.pwd = :pwd , U.name= :name "
          +"WHERE U.seq = :seq" )
    public void updateRow(@Param("seq") Integer seq,
                          @Param("id") String id,
                          @Param("pwd") String pwd,
                          @Param("name") String name);
}
