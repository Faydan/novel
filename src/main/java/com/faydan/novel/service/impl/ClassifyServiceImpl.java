package com.faydan.novel.service.impl;

import com.faydan.novel.entity.Classify;
import com.faydan.novel.repository.ClassifyRepository;
import com.faydan.novel.service.ClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Resource
    private ClassifyRepository classifyRepository;

    @Override
    public Classify findOne(Integer classifyId) {
        return classifyRepository.findById(classifyId).get();
    }

    @Override
    public List<Classify> findListByLevel(int level) {
        return classifyRepository.findByLevel(level);
    }
}
