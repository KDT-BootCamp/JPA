package jpa.com.jpa_pjt.jpa.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.com.jpa_pjt.jpa.domain.entity.SampleEntity;
import jpa.com.jpa_pjt.jpa.service.SampleService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/jap")
@RequiredArgsConstructor // 스프링은 객체 생성이 안되잖아, AutoWired와 비슷한 기능으로 
                         // 변수에 final을 붙이면 현재 파일의 생성자의 인자로 들어가 special 생성자를 만듦
public class SampleCtrl {

    private final SampleService sampleService;

    @PostMapping("/save")
    public ResponseEntity<SampleEntity> save(@RequestBody SampleEntity entity) {
        System.out.println("client endpoint : /api/jpa/save" + sampleService);
        SampleEntity result = sampleService.save(entity);
        System.out.println("debug >>> result " + result);
        
        return new ResponseEntity<>(result,HttpStatus.OK);

    }
    
    @GetMapping("/list")
    public ResponseEntity<List<SampleEntity>> list() {
        System.out.println("client endpoint : /api/jpa/list" + sampleService);
        List<SampleEntity> list = sampleService.list();
        System.out.println("debug >>> result " + list);
        
        return new ResponseEntity<>(list,HttpStatus.OK);        
    }
    
    @GetMapping("/find")
    //RequestParam, RequestBody는 path에 직접 ?seq=seq 이런식으로 지정 안해도 쿼리스트링의 변수가 메서드
    //파라미터에서 @RequestParam(name = "seq") 이런 식으로 선언하면 "seq"에 알아서 값이 할당됨
    public ResponseEntity<SampleEntity> find(@RequestParam(name = "seq") Integer seq) {
        
        System.out.println("client endPoint : /api/jpa/find" + sampleService);
        System.out.println("debug >>> seq " + seq);
        Optional <SampleEntity> entity = sampleService.find(seq);

        if(entity.isPresent()){
            return new ResponseEntity<>(entity.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/delete{seq}")
    public ResponseEntity<Void> delete(@PathVariable(name = "seq") Integer seq){
        System.out.println("client endPoint : /api/jpa/delete" + sampleService);
        System.out.println("debug >>> seq : " + seq);
        
        sampleService.delete(seq);
 
        System.out.println("service delete end");
 
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody SampleEntity entity){
        System.out.println("client endPoint : /api/jpa/update" + sampleService);
        System.out.println("debug >>> entity : " + entity);
        
        sampleService.update3(entity);
 
        System.out.println("service update end ");
 
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
