package com.project.veganpleasure.global.config;

import com.google.gson.Gson;
import com.project.veganpleasure.domain.store.entity.Store;
import com.project.veganpleasure.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;

    @PostConstruct
    public void init() throws IOException, ParseException {
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        private final StoreRepository storeRepository;

        public void dbInit() throws IOException, ParseException {
            ClassPathResource resource = new ClassPathResource("data/data.json");
            Path path = Paths.get(resource.getURI());
            System.out.println("path = " + path);
            JSONArray jsonList = (JSONArray) new JSONParser().parse(new FileReader(path.toString()));


            for (Object o : jsonList) {
                Store store = new Gson().fromJson(o.toString(), Store.class);
                store.setUploadFile(null);
                if(store.getMenu().length() > 255){
                    store.setMenu("범인이구나!");
                }
                storeRepository.save(store);
            }
        }
    }
}
