package com.example.demo.CatFact.QueryHandler;

import com.example.demo.CatFact.DTO.CatFact;
import com.example.demo.CatFact.DTO.CatFactDTO;
import com.example.demo.CatFact.Entity.CatFactEntity;
import com.example.demo.CatFact.Repository.CatFactEntityRepository;
import com.example.demo.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CatFactQueryHandler implements Query<Void, CatFactDTO> {

    private final RestTemplate restTemplate;

    private final CatFactEntityRepository catFactEntityRepository;
    public CatFactQueryHandler(RestTemplate restTemplate, CatFactEntityRepository catFactEntityRepository) {
        this.restTemplate = restTemplate;
        this.catFactEntityRepository = catFactEntityRepository;
    }

    @Override
    public ResponseEntity<CatFactDTO> excute(Void Input) {
        try {
            CatFact catFact = restTemplate.getForObject("https://catfact.ninja/fact", CatFact.class);
//            CatFact catFact = getCatFact();
            catFactEntityRepository.save(new CatFactEntity(catFact));
            CatFactDTO catFactDTO = null;
            if (catFact != null) catFactDTO = new CatFactDTO(catFact.getFact());
            return ResponseEntity.ok(catFactDTO);
        } catch (Exception ex) {
//            throw new ExternalCatFactException("none cat");
            throw new RuntimeException("loi roi check lai di");
        }

    }

}
