package com.faydan.novel.service;

import com.faydan.novel.entity.Classify;

import java.util.List;

public interface ClassifyService {
    Classify findOne(Integer classifyId);

    List<Classify> findListByLevel(int level);
}
