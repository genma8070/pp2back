package com.example.enquete_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enquete_back.repository.OptionDao;
import com.example.enquete_back.service.ifs.OptionService;
@Service
public class OptionServiceImpl implements OptionService {
	 @Autowired
	    private OptionDao optionDao;

//	 @Override
//	 public void addOption(Integer questionId, String optionText) {
//	     Option option = new Option();
//	     option.setQuestionId(questionId);
//	     option.setOptionText(optionText);
//	     optionDao.save(option);
//	 }

//	    @Override
//	    public List<Option> getOptionsByQuestionId(Integer questionId) {
//	        return questionDao.findAllByQuestionId(questionId);
//	    }
}