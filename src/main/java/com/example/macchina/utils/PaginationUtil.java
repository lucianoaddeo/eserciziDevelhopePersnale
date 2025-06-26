package com.example.macchina.utils;

import com.example.macchina.dto.PaginationDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationUtil {

    public static Pageable create(PaginationDTO pg){

        Sort sort = Sort.by(pg.getSortProperty()).ascending();

        if(pg.getSortDir() == PaginationDTO.SortDirection.DESC){
            sort = sort.descending();
        }

        return PageRequest.of(pg.getPageNum(), pg.getPageSize(), sort);
    }
}
