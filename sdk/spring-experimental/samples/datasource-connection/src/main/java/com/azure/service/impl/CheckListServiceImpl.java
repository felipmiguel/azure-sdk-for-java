package com.azure.service.impl;

import java.util.List;
import java.util.Optional;

import com.azure.exception.ResourceNotFoundException;
import com.azure.model.CheckItem;
import com.azure.model.Checklist;
import com.azure.repository.CheckItemRepository;
import com.azure.repository.CheckListRepository;
import com.azure.service.CheckListService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;

public class CheckListServiceImpl implements CheckListService {

    @Override
    public Optional<Checklist> findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Checklist> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Checklist save(Checklist checklist) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CheckItem addCheckItem(Long checklistId, @Valid CheckItem checkItem) {
        // TODO Auto-generated method stub
        return null;
    }

    // private CheckListRepository checkListRepository;
    // private CheckItemRepository checkItemRepository;

    // @Inject
    // public CheckListServiceImpl(CheckListRepository checkListRepository, CheckItemRepository checkItemRepository) {
    //     this.checkListRepository = checkListRepository;
    //     this.checkItemRepository = checkItemRepository;
    // }

    // @Override
    // public Optional<Checklist> findById(Long id) {
    //     return checkListRepository.findById(id);
    // }

    // @Override
    // public void deleteById(Long id) {
    //     checkListRepository.deleteById(id);
        
    // }

    // @Override
    // public List<Checklist> findAll() {
    //     return checkListRepository.findAll();
    // }

    // @Override
    // public Checklist save(Checklist checklist) {
    //     return checkListRepository.save(checklist);
    // }

    // @Override
    // public CheckItem addCheckItem(Long checklistId, @Valid CheckItem checkItem) {
    //     Checklist checkList = checkListRepository.findById(checklistId).orElseThrow(()-> new ResourceNotFoundException("Checklist " + checklistId + " not found"));
    //     checkItem.setCheckList(checkList);
    //     return checkItemRepository.save(checkItem);
    // }
}
