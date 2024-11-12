package jpa.com.jpa_pjt.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpa.com.jpa_pjt.jpa.dao.SampleDAO;
import jpa.com.jpa_pjt.jpa.domain.entity.SampleEntity;
import java.util.List;
import java.util.Optional;
@Service
public class SampleService {
    // Mybatis >> XXXXMapper - @Mapper, mybatis는 객체
    // JPA >>> XXXXDAO - @Repository    

    @Autowired
    private SampleDAO sampleDAO;

    public SampleEntity save(SampleEntity params) {
        System.out.println("service save >> " + params);
    
        sampleDAO.save(params);

        return params;
    }

    public List<SampleEntity> list () {
        System.out.println("service list");
        List<SampleEntity> list = sampleDAO.findAll();

        return list;
    }

    public Optional<SampleEntity> find(Integer id){
        System.out.println("service find ");
        Optional<SampleEntity> optional = sampleDAO.findById(id);
        return optional;
    }

    public void delete(Integer seq) {
        System.out.println("service delete start");
        sampleDAO.deleteById(seq);
    }
    // update case 1
    public SampleEntity update(SampleEntity entity){
        System.out.println("service update start");
    
        return sampleDAO.save(entity);
    }

    // update case 2
    // dirty checking(변경감지) >> entity의 최초 정보와 entity 변경된 부분 비교해서 자동으로 update
    // case 1 풀어서 코드로 작성한 거 , findById 해서 존재하면 save를 통해 변경사항만 저장하는 것을 save(Entity entity)가 대신함
    @Transactional
    public SampleEntity update2(SampleEntity entity){
        System.out.println("service update start");
    
        Optional<SampleEntity> optional = sampleDAO.findById(entity.getSeq());
        
        if(optional.isPresent()){
            SampleEntity sampleEntity = optional.get();
            sampleEntity.setId(entity.getId());            
            sampleEntity.setName(entity.getName());            
            sampleEntity.setPwd(entity.getPwd());      
            return sampleDAO.save(sampleEntity);      
        } else {
            return null;
        }    
    }

    //case 3 
    public void update3(SampleEntity entity){
        System.out.println("service update start");
    
        sampleDAO.updateRow(entity.getSeq(),entity.getId(),entity.getPwd(),entity.getName());

    }
}
